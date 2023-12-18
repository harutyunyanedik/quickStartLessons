package com.example.quickstartlessons.core.net

import androidx.annotation.Keep
import com.example.quickstartlessons.module.albums.data.model.responce.AlbumDto
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun <T> getHttpResponse(
    resultCallBack: ApiResultCallback<AlbumDto?>,
    isShowLoader: Boolean = true,
    apiFunction: () -> Response<ArrayList<AlbumDto>?>?
) {
    if (isShowLoader) {
//        BaseFragment.addLoader()
    }
    withContext(
        Dispatchers.IO + MyCoroutineExceptionHandler(
            CoroutineExceptionHandler,
            resultCallBack
        )
    ) {
        val response = apiFunction()
        val responseBody = response?.body()

        withContext(
            Dispatchers.Main + MyCoroutineExceptionHandler(
                CoroutineExceptionHandler, resultCallBack
            )
        ) {
            if (isShowLoader) {
//                BaseFragment.removeLoader()
            }
            if (response?.isSuccessful == true) {
                resultCallBack.onSuccess(responseBody)
            } else {
                //Remove loader again for sequence calls
                if (isShowLoader) {
//                    BaseFragment.removeLoader()
                }
                resultCallBack.onNotHandledError(response?.errorBody())
            }
        }
    }
}

@Keep
interface ApiResultCallback<T> {
    fun onSuccess(response: Any?)

    fun onError(): Boolean = false

    fun onNotHandledError(error: Any? = null) {}
}