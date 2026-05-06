package com.boolder.boolderflo.domain.model

import androidx.room.Embedded
import com.boolder.boolderflo.data.database.entity.AreaEntity

data class AreasEntityWithBeginnerCircuitsCount(
    @Embedded val areaEntity: AreaEntity,
    val beginnerCircuitsCount: Int
)
