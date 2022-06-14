package com.android.intex_market.ui.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.intex_market.R
import com.android.intex_market.adapter.admin.AdminProductAdapter
import com.android.intex_market.adapter.admin.BookingListAdapter
import com.android.intex_market.databinding.FragmentAdminProductBinding
import com.android.intex_market.databinding.FragmentBookingListBinding
import com.android.intex_market.model.BookingModel
import com.android.intex_market.model.ProductModel
import com.android.intex_market.networking.ApiClient
import com.android.intex_market.ui.BaseFragment
import com.android.intex_market.utils.CategoryInfo
import com.android.intex_market.utils.viewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookingListFragment : BaseFragment(R.layout.fragment_booking_list) {
    private val binding by viewBinding { FragmentBookingListBinding.bind(it) }
    private val adapter by lazy { BookingListAdapter() }
    lateinit var booking:ArrayList<BookingModel>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        booking = ArrayList()

        apiBookingList()

        adapter.bDeleteClick = {

        }

        adapter.bAcceptClick ={

        }
    }

    private fun apiBookingList() {
        ApiClient.apiService.listBooking().enqueue(object : Callback<ArrayList<BookingModel>> {
            override fun onResponse(
                call: Call<ArrayList<BookingModel>>,
                response: Response<ArrayList<BookingModel>>
            ) {
                if (response.body() != null) {
                    booking.addAll(response.body()!!)
                    refreshAdapter(booking)
                }
            }

            override fun onFailure(call: Call<ArrayList<BookingModel>>, t: Throwable) {
                toasty("Something is wrong")
            }

        })

}
    private fun refreshAdapter(body: ArrayList<BookingModel>?) {
        adapter.submitList(body)
        binding.rvBooking.adapter = adapter
    }
}