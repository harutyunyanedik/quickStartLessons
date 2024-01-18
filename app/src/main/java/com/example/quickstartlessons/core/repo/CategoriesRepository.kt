package com.example.quickstartlessons.core.repo

import com.example.quickstartlessons.core.ApiResultCallback
import com.example.quickstartlessons.core.getHttpResponse
import com.example.quickstartlessons.core.net.CategoriesDataSource

interface CategoriesRepository {
    suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean)

}

class CategoriesRepositoryImplementation(private val dataSource: CategoriesDataSource): CategoriesRepository{
    override suspend fun getCategories(resultCallback: ApiResultCallback<List<String>?>, isShowLoader: Boolean) {
        getHttpResponse(resultCallback,isShowLoader){
            dataSource.getCategories()
        }
    }

}

