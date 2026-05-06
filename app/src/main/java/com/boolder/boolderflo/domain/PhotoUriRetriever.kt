package com.boolder.boolderflo.domain

import android.net.Uri
import androidx.annotation.VisibleForTesting
import com.boolder.boolderflo.data.network.repository.TopoRepository
import com.boolder.boolderflo.offline.FileExplorer

class PhotoUriRetriever(
    private val topoRepository: TopoRepository,
    private val fileExplorer: FileExplorer
) {

    fun getPhotoUri(topoId: Int, areaId: Int): String =
        getLocalImageUri(topoId = topoId, areaId = areaId)
            ?: topoRepository.getTopoPictureById(topoId)

    @VisibleForTesting
    fun getLocalImageUri(topoId: Int, areaId: Int): String? =
        fileExplorer
            .getTopoImageFile(areaId = areaId, topoId = topoId)
            ?.let(Uri::fromFile)
            ?.toString()
}
