package com.android.intex_market.model

data class BookingModel(
    val active: Boolean,
    val address: String,
    val count: Int,
    val date: String,
    val id: Int,
    val image: String,
    val money: String,
    val name: String,
    val phone: String,
    val pool_frame: String,
    val product_name: String
)