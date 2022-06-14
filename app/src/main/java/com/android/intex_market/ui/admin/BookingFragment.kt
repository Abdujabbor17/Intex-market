package com.android.intex_market.ui.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.android.intex_market.R
import com.android.intex_market.adapter.VPAdapter
import com.android.intex_market.databinding.FragmentAdminProductBinding
import com.android.intex_market.databinding.FragmentBookingBinding
import com.android.intex_market.ui.BaseFragment
import com.android.intex_market.utils.viewBinding
import com.google.android.material.tabs.TabLayout

class BookingFragment : BaseFragment(R.layout.fragment_booking) {
    private val binding by viewBinding { FragmentBookingBinding.bind(it) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val viewPagerAdapter = VPAdapter(childFragmentManager, lifecycle)
        binding.apply {
            viewPager.adapter = viewPagerAdapter

            tabLayout.addTab(tabLayout.newTab().setText("Booking"))
            tabLayout.addTab(tabLayout.newTab().setText("Consulting"))

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    viewPager.currentItem = tab!!.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }
            })

            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    tabLayout.selectTab(tabLayout.getTabAt(position))
                }
            })
        }
    }
}