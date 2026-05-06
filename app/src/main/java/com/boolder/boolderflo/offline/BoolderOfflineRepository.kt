package com.boolder.boolderflo.offline

import androidx.work.BackoffPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkRequest
import androidx.work.workDataOf
import com.boolder.boolderflo.offline.worker.PhotosDownloadWorker
import com.boolder.boolderflo.utils.FileSizeFormatter
import com.boolder.boolderflo.view.offlinephotos.model.OfflineAreaItemStatus
import java.util.concurrent.TimeUnit

class BoolderOfflineRepository(
    private val workManager: WorkManager,
    private val fileExplorer: FileExplorer,
    private val fileSizeFormatter: FileSizeFormatter
) {

    fun getStatusForAreaId(areaId: Int): OfflineAreaItemStatus {
        val isDownloading = workManager
            .getWorkInfosForUniqueWork(areaId.getDownloadTopoImagesWorkName())
            .get()
            .any { it.state == WorkInfo.State.ENQUEUED || it.state == WorkInfo.State.RUNNING }

        if (isDownloading) return OfflineAreaItemStatus.Downloading(areaId)

        val areaFolderSize = fileExplorer.areaFolderSize(areaId)

        return when (areaFolderSize > 0L) {
            true -> OfflineAreaItemStatus.Downloaded(
                folderSize = fileSizeFormatter.formatBytesSize(areaFolderSize)
            )
            else -> OfflineAreaItemStatus.NotDownloaded
        }
    }

    fun downloadArea(areaId: Int) {
        val workInputData = workDataOf("areaId" to areaId)
        val downloadPhotosTask = OneTimeWorkRequestBuilder<PhotosDownloadWorker>()
            .setInputData(workInputData)
            .addTag("download-topo-images-$areaId")
            .setBackoffCriteria(
                backoffPolicy = BackoffPolicy.EXPONENTIAL,
                backoffDelay = WorkRequest.MIN_BACKOFF_MILLIS,
                timeUnit = TimeUnit.SECONDS
            )
            .build()

        workManager.enqueueUniqueWork(
            areaId.getDownloadTopoImagesWorkName(),
            ExistingWorkPolicy.KEEP,
            downloadPhotosTask
        )
    }

    fun cancelAreaDownload(areaId: Int) {
        workManager.cancelUniqueWork(areaId.getDownloadTopoImagesWorkName())
    }

    fun deleteArea(areaId: Int) {
        fileExplorer.deleteFolder(areaId)
    }
}
