package com.example.uxdesign.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        list.add(News("test"))
        list.add(News("test"))
        list.add(News("test"))
        setLayoutManager()
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