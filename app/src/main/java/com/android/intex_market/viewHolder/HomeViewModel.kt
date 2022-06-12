package com.android.intex_market.viewHolder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.intex_market.model.ProductModel
import com.android.intex_market.networking.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel:ViewModel() {

    val allProducts = MutableLiveData<ArrayList<ProductModel>?>()

    fun apiProductList() {

        ApiClient.apiService.listProducts().enqueue(object : Callback<ArrayList<ProductModel>> {
            override fun onResponse(call: Call<ArrayList<ProductModel>>, response: Response<ArrayList<ProductModel>>) {
                allProducts.value = response.body()
            }

            override fun onFailure(call: Call<ArrayList<ProductModel>>, t: Throwable) {
                allProducts.value = null
            }
        })

    }


}