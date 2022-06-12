package com.android.intex_market.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.intex_market.R
import com.android.intex_market.adapter.ProductAdapter
import com.android.intex_market.databinding.FragmentHomeBinding
import com.android.intex_market.model.ProductModel
import com.android.intex_market.networking.ApiClient
import com.android.intex_market.ui.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : BaseFragment(R.layout.fragment_home) {
    private val adapter by lazy { ProductAdapter() }
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        initViews()
        return binding.root
    }

    private fun initViews() {
        apiProductList()


        adapter.bookClick = {
            showBookingDialog()
        }
    }

    private fun apiProductList() {
        ApiClient.apiService.listProducts().enqueue(object : Callback<ArrayList<ProductModel>> {
            override fun onResponse(
                call: Call<ArrayList<ProductModel>>,
                response: Response<ArrayList<ProductModel>>
            ) {
                refreshAdapter(response.body())
            }

            override fun onFailure(call: Call<ArrayList<ProductModel>>, t: Throwable) {

            }
        })
    }

    private fun refreshAdapter(body: ArrayList<ProductModel>?) {
        adapter.submitList(body)
        binding.rvProduct.adapter = adapter
    }


}