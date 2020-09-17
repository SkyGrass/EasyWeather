package com.skygrass.easyweather.logic.network

import com.skygrass.easyweather.EasyWeatherApplication
import com.skygrass.easyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    /*
    * get 注解 当调用searchPlaces 方法时候，会自动发出get请求
    * 返回值会被解析为PlaceResponse的json格式
    * */
    @GET("v2/place?token=${EasyWeatherApplication.API_TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}