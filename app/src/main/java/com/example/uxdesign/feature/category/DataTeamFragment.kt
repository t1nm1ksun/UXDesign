package com.example.uxdesign.feature.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.example.uxdesign.R
import com.example.uxdesign.WebViewFragment
import com.example.uxdesign.databinding.FragmentDataTeamBinding

class DataTeamFragment : Fragment() {
    private var _binding : FragmentDataTeamBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDataTeamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivSeoulPlayer.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fcv_main, DataPlayerFragment::class.java.newInstance()).addToBackStack(null).commit()
        }

        binding.ivSeoulPlayer2.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fcv_main, DataPlayerFragment::class.java.newInstance()).addToBackStack(null).commit()
        }

        binding.tvSeoulRecentNews1.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val url = "https://n.news.naver.com/sports/kfootball/article/011/0004268547" // 전달하려는 데이터
            val fragment = WebViewFragment.newInstance(url)
            fragmentTransaction.add(R.id.fcv_main, fragment).addToBackStack(null).commit()
        }

        binding.tvSeoulRecentNews2.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val url = "https://n.news.naver.com/sports/kfootball/article/436/0000080336" // 전달하려는 데이터
            val fragment = WebViewFragment.newInstance(url)
            fragmentTransaction.add(R.id.fcv_main, fragment).addToBackStack(null).commit()
        }

        binding.tvSeoulRecentNews2.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val url = "https://n.news.naver.com/sports/kfootball/article/003/0012229538" // 전달하려는 데이터
            val fragment = WebViewFragment.newInstance(url)
            fragmentTransaction.add(R.id.fcv_main, fragment).addToBackStack(null).commit()
        }

        binding.btnSeoulTeamBack.setOnClickListener {
            val fragmentContainerId = R.id.fcv_main

            // Fragment를 찾아서 제거
            val fragment = requireActivity().supportFragmentManager.findFragmentById(fragmentContainerId)
            if (fragment != null) {
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.remove(fragment)
                fragmentTransaction.commit()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}