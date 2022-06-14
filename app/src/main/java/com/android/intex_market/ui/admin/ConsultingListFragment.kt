package com.android.intex_market.ui.admin

import android.os.Bundle
import android.view.View
import com.android.intex_market.R
import com.android.intex_market.adapter.admin.ConsultingListAdapter
import com.android.intex_market.databinding.FragmentConsultingListBinding
import com.android.intex_market.model.ConsultingModel
import com.android.intex_market.networking.ApiClient
import com.android.intex_market.ui.BaseFragment
import com.android.intex_market.utils.viewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ConsultingListFragment : BaseFragment(R.layout.fragment_consulting_list) {
    private val binding by viewBinding { FragmentConsultingListBinding.bind(it) }

    private val adapter by lazy { ConsultingListAdapter() }
    lateinit var consult:ArrayList<ConsultingModel>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        consult = ArrayList()

        apiBookingList()

        adapter.bDeleteClick = {

        }

        adapter.bAcceptClick = {

        }
    }

    private fun apiBookingList() {
        ApiClient.apiService.listConsultation().enqueue(object : Callback<ArrayList<ConsultingModel>> {
            override fun onResponse(
                call: Call<ArrayList<ConsultingModel>>,
                response: Response<ArrayList<ConsultingModel>>
            ) {
                if (response.body() != null) {
                    consult.addAll(response.body()!!)
                    refreshAdapter(consult)
                }
            }

            override fun onFailure(call: Call<ArrayList<ConsultingModel>>, t: Throwable) {
                toasty("Something is wrong")
            }

        })

    }

    private fun refreshAdapter(body: ArrayList<ConsultingModel>?) {
        adapter.submitList(body)
        binding.rvConsulting.adapter = adapter
    }

}