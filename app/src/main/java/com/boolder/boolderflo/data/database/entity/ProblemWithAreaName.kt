package com.boolder.boolderflo.data.database.entity

import androidx.room.Embedded

data class ProblemWithAreaName(
    @Embedded val problemEntity: ProblemEntity,
    val areaName: String
)
