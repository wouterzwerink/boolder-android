package com.boolder.boolderflo.data.database.repository

import com.boolder.boolderflo.data.database.dao.LineDao
import com.boolder.boolderflo.data.database.entity.LineEntity

class LineRepository(
    private val lineDao: LineDao
) {

    suspend fun loadAllByTopoIds(topoId: Int): List<LineEntity> {
        return lineDao.loadByTopoId(topoId)
    }

    suspend fun loadByProblemId(problemId: Int): LineEntity? {
        return lineDao.loadByProblemId(problemId)
    }
}
