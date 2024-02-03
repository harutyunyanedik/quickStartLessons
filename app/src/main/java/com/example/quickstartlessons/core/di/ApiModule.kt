package com.example.quickstartlessons.core.di

import com.example.quickstartlessons.core.room.dao.net.createOkHttpClient
import com.example.quickstartlessons.core.room.dao.net.createWebService
import com.example.quickstartlessons.core.room.dao.net.repo.datasource.ProductsDataSource
import com.example.quickstartlessons.core.room.dao.net.repo.repository.ProductRepositoryImplementation
import com.example.quickstartlessons.core.room.dao.net.repo.repository.ProductsRepository
import com.example.quickstartlessons.module.base.utils.QsConstants.PRODUCTS_BASE_URL
import org.koin.dsl.module

internal val apiModule = module {

    single { createWebService<ProductsDataSource>(createOkHttpClient(), PRODUCTS_BASE_URL) }

    single<ProductsRepository> { ProductRepositoryImplementation(get()) }

}