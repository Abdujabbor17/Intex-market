package com.android.intex_market.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.android.intex_market.R
import com.android.intex_market.databinding.ActivityAdminBinding


class AdminActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdminBinding
    lateinit var navController: NavController
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAdminBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //initViews()
        setNavigation()
//        navController = findNavController(R.id.nav_host_fragment)
//        binding.bottomNavigationView.setupWithNavController(navController)
    }

   /* private fun initViews() {


        binding.apply {
            bottomNavigationView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.productFragment2 -> {
                        viewPager.setCurrentItem(0)
                    }
                    R.id.bookingFragment -> {
                        viewPager.setCurrentItem(1)
                    }
                    R.id.siteFragment -> {
                        viewPager.setCurrentItem(3)
                    }
                }
                true
            }

            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    index = position
                    bottomNavigationView.menu.getItem(index).setChecked(true)
                }

                override fun onPageScrollStateChanged(state: Int) {

                }

            })
            setupViewPager(viewPager)
        }
    }*/

   /* private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(AdminCategoryFragment())
        adapter.addFragment(BookingFragment())
        adapter.addFragment(SiteFragment())
        viewPager.adapter = adapter
    }

    fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
*/
    private fun setNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)
    }


}