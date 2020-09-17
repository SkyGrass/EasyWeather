package com.skygrass.easyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/*统一网络调用入口*/
object EasyWeatherNetWork {
    /*请求地址的网络请求对象*/
    private val placeService = ServiceCreator.create(PlaceService::class.java)

    /*定义了调用地址请求对象中请求地址方法的方法*/
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    /*借助携程 定义await方法，将网络请求设置为挂起函数*/
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

            })
        }
    }
}