package com.android.intex_market.networking

import com.android.intex_market.networking.service.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val IS_TESTER = true
     val SERVER_DEVELOPMENT = "https://mamirovs.pythonanywhere.com/"
    private val SERVER_PRODUCTION = ""

    val retrofit: Retrofit = Retrofit.Builder().
    baseUrl(server()).
        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun server(): String {
        if (IS_TESTER) return SERVER_DEVELOPMENT
        return SERVER_PRODUCTION
    }

    val apiService: ApiService = retrofit.create(ApiService::class.java)

}