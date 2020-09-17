package com.skygrass.easyweather

import android.app.Application
import android.content.Context

/*Application实现，用于全局获取Context*/
class EasyWeatherApplication : Application() {
    companion object {
        lateinit var context: Context

        /*彩云天气申请的Api Token*/
        const val API_TOKEN: String = "e7R92C3fWLuknNSJ"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}