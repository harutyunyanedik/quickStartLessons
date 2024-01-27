package com.example.quickstartlessons.core.di

import com.example.quickstartlessons.module.details.ProductDetailsFragment
import com.example.quickstartlessons.module.details.ProductDetailsViewModel
import com.example.quickstartlessons.module.home.HomeMainTabFragment
import com.example.quickstartlessons.module.home.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val appModule = module {

    scope(named<HomeMainTabFragment>()) {
        viewModel { ProductsViewModel(get()) }
    }

    scope(named<ProductDetailsFragment>()) {
        viewModel { ProductDetailsViewModel(get()) }
    }
}