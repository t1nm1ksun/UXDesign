package com.example.uxdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.uxdesign.databinding.ActivityMainBinding
import com.example.uxdesign.feature.board.BoardFragment
import com.example.uxdesign.feature.category.CategoryFragment
import com.example.uxdesign.feature.favorite.FavoriteFragment
import com.example.uxdesign.feature.home.HomeFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBnvItemSelectedListener()
        setTabLayout()
    }

    private fun setTabLayout() {

    }

    private fun initBnvItemSelectedListener() {
        supportFragmentManager.findFragmentById(R.id.fcv_main) ?: navigateTo<HomeFragment>()

        binding.bnvMain.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.menu_home -> {
                    navigateTo<HomeFragment>()
                }

                R.id.menu_category -> navigateTo<CategoryFragment>()
                R.id.menu_favorite -> {
                    navigateTo<FavoriteFragment>()
                }

                R.id.menu_board -> navigateTo<BoardFragment>()
            }
            true
        }
    }

    private inline fun <reified T : Fragment> navigateTo() {
        supportFragmentManager.commit {
            replace<T>(R.id.fcv_main, T::class.java.canonicalName)
        }
    }
}