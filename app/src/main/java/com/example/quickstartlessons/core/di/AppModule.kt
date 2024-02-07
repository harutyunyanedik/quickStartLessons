package com.example.quickstartlessons.core.di

import com.example.quickstartlessons.module.details.ProductDetailsFragment
import com.example.quickstartlessons.module.details.ProductDetailsViewModel
import com.example.quickstartlessons.module.home.HomeMainTabFragment
import com.example.quickstartlessons.module.home.ProductsViewModel
import com.example.quickstartlessons.module.home.SearchFragment
import com.example.quickstartlessons.module.home.SearchedProductsViewModel
import com.example.quickstartlessons.module.launch.SplashActivity
import com.example.quickstartlessons.module.launch.UsersViewModel
import com.example.quickstartlessons.module.posts.PostsFragment
import com.example.quickstartlessons.module.posts.PostsViewModel
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

    scope(named<SplashActivity>()) {
        viewModel { UsersViewModel(get()) }
    }
    scope(named<SearchFragment>()) {
        viewModel { SearchedProductsViewModel(get()) }
    }

    scope(named<PostsFragment>()) {
        viewModel { PostsViewModel(get()) }
    }
}