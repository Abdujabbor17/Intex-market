package com.android.intex_market.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.intex_market.App
import com.android.intex_market.databinding.ActivityAdminOrUserBinding

class AdminOrUser : AppCompatActivity() {
    lateinit var binding: ActivityAdminOrUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAdminOrUserBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            adminBtn.setOnClickListener {
                openAdminActivity()
            }
            userBtn.setOnClickListener {
                openMainActivity()
            }
        }
    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun openAdminActivity() {
        val intent = Intent(this, AdminActivity::class.java)
        startActivity(intent)
        finish()
    }


}