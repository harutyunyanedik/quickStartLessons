package com.example.quickstartlessons.core.di

import com.example.quickstartlessons.core.net.DataSource
import com.example.quickstartlessons.core.net.createOkHttpClient
import com.example.quickstartlessons.core.net.createWebService
import com.example.quickstartlessons.core.repo.ProductsRepositoryImplementation
import com.example.quickstartlessons.core.repo.Repository
import com.example.quickstartlessons.module.base.utils.QsConstants.PRODUCTS_BASE_URL
import org.koin.dsl.module

internal val apiModule = module {

    single { createWebService<DataSource>(createOkHttpClient(), PRODUCTS_BASE_URL) }

    single<Repository> { ProductsRepositoryImplementation(get()) }

}