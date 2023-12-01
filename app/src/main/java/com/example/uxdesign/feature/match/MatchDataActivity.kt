package com.example.uxdesign.feature.match

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uxdesign.R
import com.example.uxdesign.databinding.ActivityMatchDataBinding

class MatchDataActivity : AppCompatActivity() {

    lateinit var binding : ActivityMatchDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMatchDataBack.setOnClickListener {
            finish()
        }
    }



}