package com.example.uxdesign.feature.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.uxdesign.MainActivity
import com.example.uxdesign.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        moveMain(1)
    }

    private fun moveMain(sec: Int) {
        Handler().postDelayed(Runnable {
            kotlin.run {
                val i = Intent(applicationContext, MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }, (1000 * sec).toLong())
    }
}