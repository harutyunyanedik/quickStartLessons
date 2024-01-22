package com.example.quickstartlessons.core.di

import com.example.quickstartlessons.module.albums.presentation.AlbumsViewModel
import com.example.quickstartlessons.module.home.HomeMainTabFragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val appModule = module {

    scope(named<HomeMainTabFragment>()) {
        viewModel { AlbumsViewModel(get()) }
    }
}