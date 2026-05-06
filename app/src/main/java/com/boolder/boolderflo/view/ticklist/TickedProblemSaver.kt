package com.boolder.boolderflo.view.ticklist

import com.boolder.boolderflo.data.userdatabase.entity.TickStatus

interface TickedProblemSaver {
    fun onSaveProblem(problemId: Int, tickStatus: TickStatus)
    fun onUnsaveProblem(problemId: Int)
}
