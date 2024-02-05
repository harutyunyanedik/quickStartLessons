package com.example.quickstartlessons.core.di

import com.example.quickstartlessons.module.home.ui.HomeMainTabFragment
import com.example.quickstartlessons.module.home.ui.searchedProducts.SearchFragment
import com.example.quickstartlessons.module.home.ui.searchedProducts.SearchedProductsViewModel
import com.example.quickstartlessons.module.home.ui.viewmodel.HomeMainTabViewModel
import com.example.quickstartlessons.module.launch.SplashActivity
import com.example.quickstartlessons.module.account.users.viewModel.UsersViewModel
import com.example.quickstartlessons.module.products.details.ProductDetailsFragment
import com.example.quickstartlessons.module.products.details.ProductDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val appModule = module {

    scope(named<HomeMainTabFragment>()) {
        viewModel { HomeMainTabViewModel(get()) }
    }

    scope(named<ProductDetailsFragment>()) {
        viewModel { ProductDetailsViewModel(get()) }
    }

    scope(named<SplashActivity>()) {
        viewModel { UsersViewModel(get()) }
    }

    scope(named<SearchFragment>()) {
        viewModel { SearchedProductsViewModel(get()) }
    }
}