package com.example.uxdesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import com.example.uxdesign.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {

    private var _binding : FragmentWebViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // WebView 설정
        val webSettings: WebSettings = binding.webView.settings
        webSettings.javaScriptEnabled = true // JavaScript 활성화

        val url = arguments?.getString(ARG_URL)!!

        // 웹 페이지 로드 (예: 구글 홈페이지)
        binding.webView.loadUrl(url)

        binding.tvWebBack.setOnClickListener {
            // Fragment를 추가할 때 사용한 container ID
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

    companion object {
        private const val ARG_URL = "arg_url"

        // WebViewFragment의 새로운 인스턴스를 만들고 데이터를 전달하는 메서드
        fun newInstance(url: String): WebViewFragment {
            val fragment = WebViewFragment()
            val args = Bundle()
            args.putString(ARG_URL, url)
            fragment.arguments = args
            return fragment
        }
    }
}