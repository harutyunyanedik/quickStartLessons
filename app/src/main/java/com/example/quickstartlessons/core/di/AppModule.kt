package com.example.quickstartlessons.core.di

import com.example.quickstartlessons.module.description.ProductDetailsFragment
import com.example.quickstartlessons.module.description.viewModel.ProductDetailsViewModel
import com.example.quickstartlessons.module.home.ui.HomeMainTabFragment
import com.example.quickstartlessons.module.home.ui.viewModel.HomeMainTabViewModel
import com.example.quickstartlessons.module.Users.viewModel.UsersViewModel
import com.example.quickstartlessons.module.launch.SplashActivity
import com.example.quickstartlessons.module.posts.PostsFragment
import com.example.quickstartlessons.module.posts.viewModel.PostsViewModel
import com.example.quickstartlessons.module.search.SearchFragment
import com.example.quickstartlessons.module.search.viewModel.SearchViewModel
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
    scope(named<PostsFragment>()) {
        viewModel {PostsViewModel(get()) }
    }
    scope(named<SearchFragment>()) {
        viewModel { SearchViewModel(get()) }
    }
}