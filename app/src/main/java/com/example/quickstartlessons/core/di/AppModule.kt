package com.example.quickstartlessons.core.di

import com.example.quickstartlessons.module.description.DescriptionFragment
import com.example.quickstartlessons.module.description.viewModel.DescriptionViewModel
import com.example.quickstartlessons.module.home.ui.HomeMainTabFragment
import com.example.quickstartlessons.module.home.ui.viewModel.HomeMainTabViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val appModule = module {

    scope(named<HomeMainTabFragment>()) {
        viewModel { HomeMainTabViewModel(get()) }
    }
    scope(named<DescriptionFragment>()) {
        viewModel { DescriptionViewModel(get()) }
    }
}