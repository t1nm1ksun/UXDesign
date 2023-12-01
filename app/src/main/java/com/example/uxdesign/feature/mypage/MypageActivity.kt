package com.example.uxdesign.feature.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uxdesign.R
import com.example.uxdesign.databinding.ActivityMypageBinding
import com.example.uxdesign.feature.login.LoginActivity

class MypageActivity : AppCompatActivity() {

    lateinit var binding : ActivityMypageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLogoutListener()
    }

    private fun setLogoutListener() {
        binding.btnMypageLogout.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}