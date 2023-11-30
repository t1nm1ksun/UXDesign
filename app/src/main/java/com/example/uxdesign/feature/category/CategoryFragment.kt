package com.example.uxdesign.feature.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R
import com.example.uxdesign.data.IsSelected
import com.example.uxdesign.data.News
import com.example.uxdesign.databinding.FragmentCategoryBinding
import com.example.uxdesign.feature.home.HomeNewsAdapter

class CategoryFragment : Fragment() {
    private var _binding : FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private var _sportsRecyclerView : RecyclerView? = null
    private val sportsRecyclerView get() = _sportsRecyclerView!!

    private var sportsList = ArrayList<IsSelected>()
    private lateinit var sportsAdapter : SportsAdapter

    private var _leagueRecyclerView : RecyclerView? = null
    private val leagueRecyclerView get() = _leagueRecyclerView!!

    private var leagueList = ArrayList<String>()
    private lateinit var leagueAdapter : HomeNewsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /***
         * listener 달기
         */
        _sportsRecyclerView = binding.rvCategorySports

        addExampleData()
        sportsAdapter.notifyDataSetChanged()

    }

    private fun setLayoutManager() {
        val layoutManager = LinearLayoutManager(this.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        sportsRecyclerView.layoutManager = layoutManager
        sportsAdapter = SportsAdapter(sportsList, this.requireContext())
        sportsRecyclerView.adapter = sportsAdapter

        val layoutManager2 = LinearLayoutManager(this.context)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL
        sportsRecyclerView.layoutManager = layoutManager2
        sportsAdapter = SportsAdapter(sportsList, this.requireContext())
        sportsRecyclerView.adapter = sportsAdapter
    }

    private fun addExampleData() {
        sportsList.add(IsSelected("축구", true))
        sportsList.add(IsSelected("야구", false))
        sportsList.add(IsSelected("농구", false))
        sportsList.add(IsSelected("배구", false))
        sportsList.add(IsSelected("골프", false))
        sportsList.add(IsSelected("게임", false))
        sportsList.add(IsSelected("양궁", false))

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}