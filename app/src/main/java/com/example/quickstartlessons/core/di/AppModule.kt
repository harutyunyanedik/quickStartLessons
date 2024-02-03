package com.example.quickstartlessons.core.di

import com.example.quickstartlessons.module.home.ui.HomeMainTabFragment
import com.example.quickstartlessons.module.home.ui.HomeMainTabViewModel
import com.example.quickstartlessons.module.home.ui.details.ProductDetailsFragment
import com.example.quickstartlessons.module.home.ui.details.ProductDetailsViewModel
import com.example.quickstartlessons.module.launch.SplashActivity
import com.example.quickstartlessons.module.launch.SplashFragment
import com.example.quickstartlessons.module.launch.SplashViewModel
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
  scope ( named<SplashFragment>()){
      viewModel{SplashViewModel(get())}
  }

}