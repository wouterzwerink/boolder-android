package com.boolder.boolderflo.view

import android.content.res.Resources
import com.boolder.boolderflo.offline.FileExplorer
import com.boolder.boolderflo.utils.FileSizeFormatter
import com.boolder.boolderflo.utils.MapboxStyleFactory
import com.boolder.boolderflo.view.areadetails.areacircuit.AreaCircuitViewModel
import com.boolder.boolderflo.view.areadetails.areaoverview.AreaOverviewViewModel
import com.boolder.boolderflo.view.areadetails.areaproblems.AreaProblemsViewModel
import com.boolder.boolderflo.view.discover.discover.DiscoverViewModel
import com.boolder.boolderflo.view.discover.driesfast.DriesFastViewModel
import com.boolder.boolderflo.view.discover.levels.LevelsViewModel
import com.boolder.boolderflo.view.discover.levels.beginner.BeginnerLevelsViewModel
import com.boolder.boolderflo.view.discover.trainandbike.TrainAndBikeViewModel
import com.boolder.boolderflo.view.fullscreenphoto.FullScreenPhotoViewModel
import com.boolder.boolderflo.view.map.MapViewModel
import com.boolder.boolderflo.view.map.filter.grade.GradesFilterViewModel
import com.boolder.boolderflo.view.offlinephotos.OfflinePhotosViewModel
import com.boolder.boolderflo.view.offlinephotos.OfflinePhotosViewModelImpl
import com.boolder.boolderflo.view.search.SearchViewModel
import com.boolder.boolderflo.view.ticklist.TickListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.binds
import org.koin.dsl.module

val viewModelModule = module {
    single<Resources> { androidApplication().resources }

    viewModelOf(::MapViewModel)
    viewModelOf(::SearchViewModel)
    factory { MapboxStyleFactory() }

    viewModelOf(::GradesFilterViewModel)

    viewModelOf(::OfflinePhotosViewModelImpl) { binds(listOf(OfflinePhotosViewModel::class)) }
    factory { FileExplorer(androidApplication()) }
    factory { FileSizeFormatter() }

    viewModelOf(::AreaOverviewViewModel)
    viewModelOf(::AreaProblemsViewModel)
    viewModelOf(::AreaCircuitViewModel)

    viewModelOf(::DiscoverViewModel)
    viewModelOf(::DriesFastViewModel)
    viewModelOf(::LevelsViewModel)
    viewModelOf(::BeginnerLevelsViewModel)
    viewModelOf(::TrainAndBikeViewModel)

    viewModelOf(::TickListViewModel)

    viewModelOf(::FullScreenPhotoViewModel)
}
