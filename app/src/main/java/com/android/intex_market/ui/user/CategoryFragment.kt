package com.android.intex_market.ui.user


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.intex_market.R
import com.android.intex_market.activity.MainActivity
import com.android.intex_market.adapter.CategoryAdapter
import com.android.intex_market.databinding.FragmentCategoryBinding
import com.android.intex_market.model.CategoryModel
import com.android.intex_market.networking.ApiClient
import com.android.intex_market.ui.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoryFragment : BaseFragment(R.layout.fragment_category) {
    private lateinit var adapter:CategoryAdapter
    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        initViews()
        return binding.root
    }

    private fun initViews() {
        apiCategoryList()

        adapter  = CategoryAdapter()

        adapter.itemClick = {
            (requireActivity() as MainActivity).loadFragment(EachCategoryFragment())
        }
    }


    private fun apiCategoryList() {
        ApiClient.apiService.listCategories().enqueue(object : Callback<ArrayList<CategoryModel>> {
            override fun onResponse(
                call: Call<ArrayList<CategoryModel>>,
                response: Response<ArrayList<CategoryModel>>
            ) {
                refreshAdapter(response.body())
            }

            override fun onFailure(call: Call<ArrayList<CategoryModel>>, t: Throwable) {
                toasty("Something is wrong")
            }
        })
    }

    private fun refreshAdapter(body: ArrayList<CategoryModel>?) {
        adapter.submitList(body)
        binding.rvCategory.adapter = adapter
    }

}