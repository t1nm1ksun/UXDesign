package com.example.uxdesign.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R
import com.example.uxdesign.WebViewFragment
import com.example.uxdesign.data.News
import com.example.uxdesign.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var _recyclerView : RecyclerView? = null
    private val recyclerView get() = _recyclerView!!

    private var list = ArrayList<News>()
    private lateinit var adapter : HomeNewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /***
         * listener 달기
         */
        _recyclerView = binding.rvHomeNews
        list.add(News(getString(R.string.home_news_title_1), R.drawable.pic_home_news_1, "https://n.news.naver.com/sports/basketball/article/001/0014365915"))
        list.add(News(getString(R.string.home_news_title_2), R.drawable.pic_home_news_2, "https://n.news.naver.com/sports/kfootball/article/311/0001664577"))
        list.add(News(getString(R.string.home_news_title_3), R.drawable.pic_home_news_3, "https://n.news.naver.com/sports/basketball/article/065/0000254661"))
        list.add(News(getString(R.string.home_news_title_4), R.drawable.pic_home_news_4, "https://n.news.naver.com/sports/kbaseball/article/144/0000929146"))
        setLayoutManager()
        setHomeNewsListener()
    }

    private fun setHomeNewsListener() {
        adapter.itemClickListener = object : HomeNewsAdapter.OnItemClickListener {
            override fun onItemClick(data: News, position: Int) {
                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                val url = data.link // 전달하려는 데이터
                val fragment = WebViewFragment.newInstance(url)
                fragmentTransaction.add(R.id.fcv_main, fragment).addToBackStack(null).commit()
            }
        }
    }

    private fun setLayoutManager() {
        val layoutManager = LinearLayoutManager(this.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager
        adapter = HomeNewsAdapter(list, this.requireContext())
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _recyclerView = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

}