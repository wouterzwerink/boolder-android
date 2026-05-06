package com.boolder.boolderflo.utils.previewgenerator

import com.boolder.boolderflo.domain.model.Area
import com.boolder.boolderflo.view.offlinephotos.model.OfflineAreaItem
import com.boolder.boolderflo.view.offlinephotos.model.OfflineAreaItemStatus

fun dummyOfflineAreaItem(
    area: Area = dummyArea(),
    status: OfflineAreaItemStatus = OfflineAreaItemStatus.NotDownloaded
) = OfflineAreaItem(
    area = area,
    status = status
)
