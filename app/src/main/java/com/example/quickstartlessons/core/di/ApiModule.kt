package com.example.quickstartlessons.core.di

import com.example.quickstartlessons.core.net.createOkHttpClient
import com.example.quickstartlessons.core.net.createWebService
import com.example.quickstartlessons.module.albums.net.datasource.AlbumDataSource
import com.example.quickstartlessons.module.albums.repository.AlbumRepository
import com.example.quickstartlessons.module.albums.repository.AlbumRepositoryImplementation
import com.example.quickstartlessons.module.base.utils.QsConstants.PRODUCTS_BASE_URL
import org.koin.dsl.module

internal val apiModule = module {

    single { createWebService<AlbumDataSource>(createOkHttpClient(), PRODUCTS_BASE_URL) }

    single<AlbumRepository> { AlbumRepositoryImplementation(get()) }

}