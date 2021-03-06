package com.android.intex_market.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.android.intex_market.App
import com.android.intex_market.R
import com.android.intex_market.databinding.ActivityMainBinding
import com.android.intex_market.ui.user.CategoryFragment
import com.android.intex_market.ui.user.ConsultingFragment
import com.android.intex_market.ui.user.HomeFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() {

        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)

        setNavigation()
    }

    private fun setNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)
    }

    fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.navHostFragment, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        binding.apply {
            when (item.itemId) {

                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    binding.bottomNavigationView.visibility = View.VISIBLE
                }

                R.id.nav_category -> {
                    loadFragment(CategoryFragment())
                    binding.bottomNavigationView.visibility = View.VISIBLE
                }
                R.id.nav_consulting -> {
                    loadFragment(ConsultingFragment())
                    binding.bottomNavigationView.visibility = View.GONE
                }
                R.id.nav_phone -> Toast.makeText(
                    App.instance,
                    "Phone button is Clicked!",
                    Toast.LENGTH_SHORT
                )
                    .show()
                R.id.nav_telegram -> Toast.makeText(
                    App.instance,
                    "Telegram button is Clicked!",
                    Toast.LENGTH_SHORT
                )
                    .show()
                R.id.nav_instagram -> {
                    Toast.makeText(
                        App.instance,
                        "Instagram button is Clicked!",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                else -> {}
            }
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}