package com.boolder.boolderflo.data.userdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.boolder.boolderflo.data.userdatabase.dao.TickedProblemDao
import com.boolder.boolderflo.data.userdatabase.entity.TickedProblemEntity

@Database(
    entities = [TickedProblemEntity::class],
    version = 1,
    exportSchema = true
)
abstract class UserDatabase : RoomDatabase() {
    abstract fun tickedProblemDao(): TickedProblemDao
}
