package com.example.uxdesign.feature.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uxdesign.R
import com.example.uxdesign.WebViewFragment
import com.example.uxdesign.databinding.FragmentKgcTeamBinding

class KgcTeamFragment : Fragment() {
    private var _binding : FragmentKgcTeamBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKgcTeamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivKgcPlayer.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fcv_main, KgcPlayerFragment::class.java.newInstance()).addToBackStack(null).commit()
        }

        binding.ivKgcPlayer2.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fcv_main, KgcPlayerFragment::class.java.newInstance()).addToBackStack(null).commit()
        }

        binding.tvKgcRecentNews1.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val url = "https://n.news.naver.com/sports/basketball/article/001/0014365915" // 전달하려는 데이터
            val fragment = WebViewFragment.newInstance(url)
            fragmentTransaction.add(R.id.fcv_main, fragment).addToBackStack(null).commit()
        }

        binding.tvKgcRecentNews2.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val url = "https://n.news.naver.com/sports/basketball/article/065/0000254661" // 전달하려는 데이터
            val fragment = WebViewFragment.newInstance(url)
            fragmentTransaction.add(R.id.fcv_main, fragment).addToBackStack(null).commit()
        }

        binding.tvKgcRecentNews3.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            val url = "https://n.news.naver.com/sports/basketball/article/065/0000254657" // 전달하려는 데이터
            val fragment = WebViewFragment.newInstance(url)
            fragmentTransaction.add(R.id.fcv_main, fragment).addToBackStack(null).commit()
        }

        binding.btnKgcTeamBack.setOnClickListener {
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