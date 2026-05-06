package com.boolder.boolderflo.domain.model

import com.boolder.boolderflo.data.userdatabase.entity.TickStatus
import com.boolder.boolderflo.data.userdatabase.entity.TickedProblemEntity

data class TickedProblem(
    val problemId: Int,
    val tickStatus: TickStatus
) {
    fun toEntity() = TickedProblemEntity(
        id = 0,
        createdAt = System.currentTimeMillis(),
        problemId = problemId,
        tickStatus = tickStatus
    )
}
