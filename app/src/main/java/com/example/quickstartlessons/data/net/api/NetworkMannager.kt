package com.example.quickstartlessons.data.net.api

import androidx.annotation.Keep
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun <T> getHttpResponse(
    resultCallBack: ApiResultCallback<T?>,
    isShowLoader: Boolean = true,
    apiFunction: suspend () -> Response<T>
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
        val responseBody = response.body()

        GlobalScope.launch(
            Dispatchers.Main + MyCoroutineExceptionHandler(
                CoroutineExceptionHandler, resultCallBack
            )
        ) {
            if (isShowLoader) {
//                BaseFragment.removeLoader()
            }
            if (response.isSuccessful) {
                resultCallBack.onSuccess(responseBody)
            } else {
                //Remove loader again for sequence calls
                if (isShowLoader) {
//                    BaseFragment.removeLoader()
                }
                resultCallBack.onNotHandledError(response.errorBody())
            }
        }
    }
}

@Keep
interface ApiResultCallback<T> {
    fun onSuccess(response: T)

    /**
     * @return true if handled
     */
    fun onError(status: Any): Boolean = false

    fun onNotHandledError(error: Any? = null) {}
}