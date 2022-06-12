package com.android.intex_market.ui.user


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.intex_market.R
import com.android.intex_market.adapter.ProductAdapter
import com.android.intex_market.databinding.FragmentEachCategoryBinding
import com.android.intex_market.model.ProductModel
import com.android.intex_market.networking.ApiClient
import com.android.intex_market.ui.BaseFragment
import com.android.intex_market.utils.CategoryInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EachCategoryFragment : BaseFragment(R.layout.fragment_each_category) {

    private val adapter by lazy { ProductAdapter() }
    private lateinit var binding: FragmentEachCategoryBinding
    lateinit var eachCategoryProduct: ArrayList<ProductModel>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEachCategoryBinding.inflate(inflater, container, false);
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.nameCategory.text = CategoryInfo.categoryname.toString()

        eachCategoryProduct = ArrayList()

        adapter.bookClick = {
            showBookingDialog()
        }
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
                            eachCategoryProduct.add(product)
                        }
                    }
                }
                refreshAdapter(eachCategoryProduct)
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