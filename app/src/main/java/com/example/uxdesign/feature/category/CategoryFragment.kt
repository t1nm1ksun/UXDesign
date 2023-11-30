package com.example.uxdesign.feature.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R
import com.example.uxdesign.data.News
import com.example.uxdesign.databinding.FragmentCategoryBinding
import com.example.uxdesign.feature.home.HomeNewsAdapter

class CategoryFragment : Fragment() {
    private var _binding : FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private var _sportsRecyclerView : RecyclerView? = null
    private val sportsRecyclerView get() = _sportsRecyclerView!!

    private var sportsList = ArrayList<String>()
    private var sportsSelectedList = ArrayList<Boolean>()
    private lateinit var sportsAdapter : SportsAdapter

    private var _leagueRecyclerView : RecyclerView? = null
    private val leagueRecyclerView get() = _leagueRecyclerView!!

    private var leagueList = ArrayList<String>()
    private var leagueSelectedList = ArrayList<Boolean>()
    private lateinit var leagueAdapter : LeagueAdapter


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
        _leagueRecyclerView = binding.rvCategoryLeague

        addExampleData()
        setLayoutManager()
        sportsAdapter.notifyDataSetChanged()

    }

    private val soccerLeagueList = ArrayList<String>()
    private val basketLeagueList = ArrayList<String>()

    private fun setLayoutManager() {
        val layoutManager = LinearLayoutManager(this.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        sportsRecyclerView.layoutManager = layoutManager
        sportsAdapter = SportsAdapter(sportsList, sportsSelectedList, this.requireContext())
        sportsRecyclerView.adapter = sportsAdapter

        leagueList = soccerLeagueList

        sportsAdapter.itemClickListener = object : SportsAdapter.OnItemClickListener {
            override fun onItemClick(data: String, position: Int) {
                when (data) {
                    "축구" -> leagueList = soccerLeagueList
                    "농구" -> leagueList = basketLeagueList
                }
                sportsAdapter.notifyDataSetChanged()
            }
        }

        val layoutManager2 = LinearLayoutManager(this.context)
        layoutManager2.orientation = LinearLayoutManager.VERTICAL
        leagueRecyclerView.layoutManager = layoutManager2
        leagueAdapter = LeagueAdapter(leagueList, leagueSelectedList, this.requireContext())
        leagueRecyclerView.adapter = leagueAdapter
    }

    private fun addExampleData() {
        sportsList.add("축구")
        sportsSelectedList.add(true)
        sportsList.add("야구")
        sportsList.add("농구")
        sportsList.add("배구")
        sportsList.add("골프")
        sportsList.add("게임")
        sportsList.add("양궁")
        repeat(6) {
            sportsSelectedList.add(false)
        }

        soccerLeagueList.add("K리그1")
        leagueSelectedList.add(true)
        soccerLeagueList.add("K리그2")
        soccerLeagueList.add("챔피언스")
        soccerLeagueList.add("유로파")
        soccerLeagueList.add("프리미어")
        soccerLeagueList.add("분데스리가")
        soccerLeagueList.add("라리가")
        soccerLeagueList.add("세리에A")
        soccerLeagueList.add("리그1")
        repeat(8) {
            leagueSelectedList.add(false)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}