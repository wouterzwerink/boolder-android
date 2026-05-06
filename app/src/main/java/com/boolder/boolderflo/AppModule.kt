package com.boolder.boolderflo

import androidx.work.WorkManager
import com.boolder.boolderflo.data.datastore.dataStore
import com.boolder.boolderflo.offline.BoolderOfflineRepository
import com.boolder.boolderflo.offline.worker.BoolderWorkerFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val appModule = module {
    factoryOf(::BoolderWorkerFactory)
    factoryOf(::BoolderOfflineRepository)
    factory { WorkManager.getInstance(androidApplication()) }
    factory { androidApplication().resources }
    single { androidApplication().dataStore }
}
