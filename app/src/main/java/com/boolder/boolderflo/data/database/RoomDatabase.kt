package com.boolder.boolderflo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.boolder.boolderflo.data.database.dao.AreaDao
import com.boolder.boolderflo.data.database.dao.CircuitDao
import com.boolder.boolderflo.data.database.dao.LineDao
import com.boolder.boolderflo.data.database.dao.ProblemDao
import com.boolder.boolderflo.data.database.entity.AreaEntity
import com.boolder.boolderflo.data.database.entity.CircuitEntity
import com.boolder.boolderflo.data.database.entity.LineEntity
import com.boolder.boolderflo.data.database.entity.PoiEntity
import com.boolder.boolderflo.data.database.entity.PoiRouteEntity
import com.boolder.boolderflo.data.database.entity.ProblemEntity

@Database(
    entities = [
        AreaEntity::class,
        CircuitEntity::class,
        LineEntity::class,
        PoiEntity::class,
        PoiRouteEntity::class,
        ProblemEntity::class
    ],
    version = 28, // increment version number everytime the boolder.db database changes (schema or data)
    exportSchema = true
)
abstract class BoolderAppDatabase : RoomDatabase() {
    abstract fun areaDao(): AreaDao
    abstract fun circuitDao(): CircuitDao
    abstract fun lineDao(): LineDao
    abstract fun problemDao(): ProblemDao
}
