package com.android.intex_market.ui.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.intex_market.R
import com.android.intex_market.databinding.FragmentAdminProductBinding
import com.android.intex_market.databinding.FragmentBookingBinding
import com.android.intex_market.ui.BaseFragment
import com.android.intex_market.utils.viewBinding

class BookingFragment : BaseFragment(R.layout.fragment_booking) {
    private val binding by viewBinding { FragmentBookingBinding.bind(it) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}