package com.example.quickstartlessons.core.net.repository

import com.example.quickstartlessons.core.net.ApiResultCallback
import com.example.quickstartlessons.core.net.CategoriesDataSource
import com.example.quickstartlessons.core.net.getHttpResponse

interface CategoriesRepository {
    suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)
}

class CategoryRepositoryImplementation(private val dataSource: CategoriesDataSource) : CategoriesRepository {
    override suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback, isShowLoader) {
            dataSource.getCategories()
        }
    }
}