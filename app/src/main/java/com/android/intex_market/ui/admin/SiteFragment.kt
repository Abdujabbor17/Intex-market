package com.android.intex_market.ui.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.intex_market.R
import com.android.intex_market.databinding.FragmentSiteBinding
import com.android.intex_market.ui.BaseFragment

class SiteFragment : BaseFragment(R.layout.fragment_site) {
    lateinit var binding:FragmentSiteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSiteBinding.inflate(layoutInflater)
        initViews()
        return binding.root
    }

    private fun initViews() {

    }

}