package com.android.intex_market.ui.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.intex_market.R
import com.android.intex_market.adapter.ProductAdapter
import com.android.intex_market.adapter.admin.AdminProductAdapter
import com.android.intex_market.databinding.FragmentAdminProductBinding
import com.android.intex_market.model.ProductModel
import com.android.intex_market.networking.ApiClient
import com.android.intex_market.ui.BaseFragment
import com.android.intex_market.utils.CategoryInfo
import com.android.intex_market.utils.viewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AdminProductFragment : BaseFragment(R.layout.fragment_admin_product) {

    private val binding by viewBinding { FragmentAdminProductBinding.bind(it) }
    private val adapter by lazy { AdminProductAdapter() }
    lateinit var products:ArrayList<ProductModel>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        products = ArrayList()

        apiProductList()
    }

    private fun apiProductList() {
        ApiClient.apiService.listProducts().enqueue(object : Callback<ArrayList<ProductModel>> {
            override fun onResponse(
                call: Call<ArrayList<ProductModel>>,
                response: Response<ArrayList<ProductModel>>
            ) {
                if (response.body() != null) {
                    for (product in response.body()!!) {
                        if (product.category == CategoryInfo.id) {
                            products.add(product)
                        }
                    }
                }
                refreshAdapter(products)
            }

            override fun onFailure(call: Call<ArrayList<ProductModel>>, t: Throwable) {
                toasty("Something is wrong")
            }
        })
    }
    private fun refreshAdapter(body: ArrayList<ProductModel>?) {
        adapter.submitList(body)
        binding.rvProduct.adapter = adapter
    }


}