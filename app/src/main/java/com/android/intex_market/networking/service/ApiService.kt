package com.android.intex_market.networking.service

import com.android.intex_market.model.BookingModel
import com.android.intex_market.model.CategoryModel
import com.android.intex_market.model.ConsultingModel
import com.android.intex_market.model.ProductModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("product/")
    fun listProducts(): Call<ArrayList<ProductModel>>

    @GET("category/")
    fun listCategories(): Call<ArrayList<CategoryModel>>

    @POST("konsultatsia/")
    fun takeConsultation(@Body consult: ConsultingModel):Call<ConsultingModel>

    @GET("konsultatsia/")
    fun listConsultation():Call<ArrayList<ConsultingModel>>

    @GET("zakaz/")
    fun listBooking(): Call<ArrayList<BookingModel>>





}