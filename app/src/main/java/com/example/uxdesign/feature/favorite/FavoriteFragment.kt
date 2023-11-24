package com.example.uxdesign.feature.favorite

import android.R
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uxdesign.databinding.FragmentFavoriteBinding

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.uxdesign.feature.home.HomeFragment
import com.google.android.material.tabs.TabLayout


class FavoriteFragment : Fragment() {
    private var _binding : FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

   /* @Nullable
    override fun onCreateView(inflater: LayoutInflater,@Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false) as ViewGroup
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item)

    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /***
         * listener 달기
         */
        /*var searchView: SearchView? = view.findViewById(R.id.search_view) as SearchView?
        val id: Int = searchView.getContext().getResources()
            .getIdentifier("android:id/search_src_text", null, null)
        searchView.findViewById(id).setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f) // 16sp*/
        setTabLayout()

    }

    private fun setTabLayout() {
        childFragmentManager.findFragmentById(com.example.uxdesign.R.id.fcv_fav) ?: navigateTo<FavPlayerFragment>()

        binding.apply {
//            tiFavPlayer.setBackgroundResource(com.example.uxdesign.R.drawable.tab_selected_style)
//            tiFavTeam.setBackgroundResource(com.example.uxdesign.R.drawable.tab_unselected_style)
            tlFav.getTabAt(0)!!.view.setBackgroundResource(com.example.uxdesign.R.drawable.tab_selected_style)
            tlFav.getTabAt(1)!!.view.setBackgroundResource(com.example.uxdesign.R.drawable.bg_transparent)

            tlFav.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if (tab != null) {
                        when (tab.position) {
                            0 -> {
                                navigateTo<FavPlayerFragment>()
                                tlFav.getTabAt(0)!!.view.setBackgroundResource(com.example.uxdesign.R.drawable.tab_selected_style)
                                tlFav.getTabAt(1)!!.view.setBackgroundResource(com.example.uxdesign.R.drawable.bg_transparent)

//                                tiFavPlayer.setBackgroundResource(com.example.uxdesign.R.drawable.tab_selected_style)
//                                tiFavTeam.setBackgroundResource(com.example.uxdesign.R.drawable.tab_unselected_style)

                            }
                            1 -> {
                                navigateTo<FavTeamFragment>()
                                tlFav.getTabAt(1)!!.view.setBackgroundResource(com.example.uxdesign.R.drawable.tab_selected_style)
                                tlFav.getTabAt(0)!!.view.setBackgroundResource(com.example.uxdesign.R.drawable.bg_transparent)

//                                tiFavTeam.setBackgroundResource(com.example.uxdesign.R.drawable.tab_selected_style)
//                                tiFavPlayer.setBackgroundResource(com.example.uxdesign.R.drawable.tab_unselected_style)
                            }
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private inline fun <reified T : Fragment> navigateTo() {
        childFragmentManager.commit {
            replace<T>(com.example.uxdesign.R.id.fcv_fav, T::class.java.canonicalName)
        }
    }

}