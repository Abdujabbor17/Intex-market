package com.android.intex_market.model

data class ConsultingModel(
    val active: Boolean,
    val date: String,
    val name: String,
    val phone: String,
    val id: Int? = null
)