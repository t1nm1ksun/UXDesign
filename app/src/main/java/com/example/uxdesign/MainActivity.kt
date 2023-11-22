package com.example.uxdesign

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.uxdesign.databinding.ActivityMainBinding
import com.example.uxdesign.feature.board.BoardFragment
import com.example.uxdesign.feature.category.CategoryFragment
import com.example.uxdesign.feature.favorite.FavoriteFragment
import com.example.uxdesign.feature.home.HomeFragment
import com.google.android.material.tabs.TabLayout

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
        // 초기 tab 세팅
        binding.tabLayoutContainer.setBackgroundResource(R.drawable.tab_select)

        binding.storeFragmentTablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            // tab이 선택되었을 때
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    /*0 -> binding.tabLayoutContainer.setBackgroundResource(R.color.purple_700)
                    1 -> binding.tabLayoutContainer.setBackgroundResource(R.color.white)
                    2 -> binding.tabLayoutContainer.setBackgroundResource(R.color.purple_200)
                    3 -> binding.tabLayoutContainer.setBackgroundResource(R.color.teal_200)
                    제가 조만간 처리하겠습니다 거의 다함!
                    */
                }
            }
            // tab이 선택되지 않았을 때
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            // tab이 다시 선택되었을 때
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
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