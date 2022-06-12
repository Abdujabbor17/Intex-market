package com.android.intex_market.ui.admin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.android.intex_market.R
import com.android.intex_market.activity.AdminActivity
import com.android.intex_market.activity.MainActivity
import com.android.intex_market.adapter.admin.AdminCategoryAdapter
import com.android.intex_market.databinding.FragmentAdminCategoryBinding
import com.android.intex_market.model.CategoryModel
import com.android.intex_market.networking.ApiClient
import com.android.intex_market.ui.BaseFragment
import com.android.intex_market.ui.user.EachCategoryFragment
import com.android.intex_market.utils.viewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Array.newInstance
import javax.xml.datatype.DatatypeFactory.newInstance
import javax.xml.transform.TransformerFactory.newInstance


class AdminCategoryFragment : BaseFragment(R.layout.fragment_admin_category) {
    private val binding by viewBinding { FragmentAdminCategoryBinding.bind(it) }
    private lateinit var adapter: AdminCategoryAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        apiCategoryList()

        adapter = AdminCategoryAdapter()

        adapter.itemClick = {
            findNavController().navigate(R.id.action_productFragment2_to_adminProductFragment)
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