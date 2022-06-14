package com.android.intex_market.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.intex_market.ui.admin.BookingListFragment
import com.android.intex_market.ui.admin.ConsultingListFragment

class VPAdapter  (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                BookingListFragment()
            }
            1 -> {
               ConsultingListFragment()
            }

            else -> Fragment()
        }
    }
}