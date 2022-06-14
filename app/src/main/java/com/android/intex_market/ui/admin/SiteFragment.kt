package com.android.intex_market.ui.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.intex_market.R
import com.android.intex_market.databinding.FragmentConsultingListBinding
import com.android.intex_market.databinding.FragmentSiteBinding
import com.android.intex_market.ui.BaseFragment
import com.android.intex_market.utils.viewBinding

class SiteFragment : BaseFragment(R.layout.fragment_site) {

    private val binding by viewBinding { FragmentSiteBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

    }

}