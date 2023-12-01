package com.example.uxdesign.feature.category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R
import com.example.uxdesign.data.News
import com.example.uxdesign.databinding.FragmentCategoryBinding
import com.example.uxdesign.feature.board.BoardTitleFragment
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

    private var _teamRecyclerView : RecyclerView? = null
    private val teamRecyclerView get() = _teamRecyclerView!!

    private var teamList = ArrayList<Int>()
    private lateinit var teamAdapter : LeagueTeamAdapter


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
        _teamRecyclerView = binding.rvCategoryTeam

        addExampleData()
        addingKleagueTeam()
        addingKBLTeam()
        setLayoutManager()
        sportsAdapter.notifyDataSetChanged()

    }

    private val soccerLeagueList = ArrayList<String>()
    private val basketLeagueList = ArrayList<String>()
    private val europaTeamList = ArrayList<Int>()

    private val kblTeamList = ArrayList<Int>()
    private val kleagueTeamList = ArrayList<Int>()

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
                    "축구" -> {
                        leagueList = soccerLeagueList
                        Log.d("uxdesign", "축구...")
                        Log.d("uxdesign", "${leagueList.size}")
                        setToSoccerLeague()

                    }
                    "농구" -> {
                        leagueList = basketLeagueList
                        Log.d("uxdesign", "농구..")
                        Log.d("uxdesign", "$leagueList")
                        Log.d("uxdesign", "${leagueList.size}")
                        setToBasketLeague()


                    }
                }
            }
        }

        // 왜 농구를 들어가도 안 바뀌는지...

//        teamList = soccerLeagueList

//        sportsAdapter.itemClickListener = object : SportsAdapter.OnItemClickListener {
//            override fun onItemClick(data: String, position: Int) {
//                when (data) {
//                    "축구" -> leagueList = soccerLeagueList
//                    "농구" -> leagueList = basketLeagueList
//                }
//                sportsAdapter.notifyDataSetChanged()
//            }
//        }

        val layoutManager2 = LinearLayoutManager(this.context)
        layoutManager2.orientation = LinearLayoutManager.VERTICAL
        leagueRecyclerView.layoutManager = layoutManager2
        leagueAdapter = LeagueAdapter(leagueList, leagueSelectedList, this.requireContext())
        leagueRecyclerView.adapter = leagueAdapter

        val layoutManger3 = GridLayoutManager(this.context, 3)
        teamRecyclerView.layoutManager = layoutManger3
        teamAdapter = LeagueTeamAdapter(teamList, this.requireContext())
        teamRecyclerView.adapter = teamAdapter

        setTeamAdapterListener()
    }

    private fun setTeamAdapterListener() {
        teamAdapter.itemClickListener = object : LeagueTeamAdapter.OnItemClickListener {
            override fun onItemClick(data: Int, position: Int) {
                if (data.equals(R.drawable.ic_fc_seoul)) {
                    val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                    fragmentTransaction.add(R.id.fcv_main, DataTeamFragment::class.java.newInstance()).addToBackStack(null).commit()
                }
                else if (data.equals(R.drawable.ic_team_redboosters)) {
                    val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                    fragmentTransaction.add(R.id.fcv_main, KgcTeamFragment::class.java.newInstance()).addToBackStack(null).commit()
                }
            }
        }
    }

    private fun testAddingLeagueTeam() {
        europaTeamList.clear()
        europaTeamList.add(R.drawable.ic_team_skknights)
        europaTeamList.add(R.drawable.ic_team_redboosters)
        europaTeamList.add(R.drawable.ic_team_skknights)
        europaTeamList.add(R.drawable.ic_team_redboosters)
        europaTeamList.add(R.drawable.ic_team_skknights)
        europaTeamList.add(R.drawable.ic_team_redboosters)
        europaTeamList.add(R.drawable.ic_team_skknights)
        europaTeamList.add(R.drawable.ic_team_redboosters)

        teamList = europaTeamList
    }

    private fun addingKBLTeam() {
        kblTeamList.clear()
        kblTeamList.add(R.drawable.ic_team_skknights)
        kblTeamList.add(R.drawable.ic_team_redboosters)
        kblTeamList.add(R.drawable.img_busan_kcc)
        kblTeamList.add(R.drawable.img_changwon_lg)
        kblTeamList.add(R.drawable.img_goyang_sono)
        kblTeamList.add(R.drawable.img_daegu_pegasus)
        kblTeamList.add(R.drawable.img_ulsan_basket)
        kblTeamList.add(R.drawable.img_wonju_db)
        kblTeamList.add(R.drawable.img_suwon_kt)
        kblTeamList.add(R.drawable.img_seoul_samsung)
    }

    private fun addingKleagueTeam() {
        kleagueTeamList.clear()
        kleagueTeamList.add(R.drawable.img_daegu_fc)
        kleagueTeamList.add(R.drawable.img_gangwon_fc)
        kleagueTeamList.add(R.drawable.img_gwangju_fc)
        kleagueTeamList.add(R.drawable.ic_fc_seoul)
        kleagueTeamList.add(R.drawable.img_suwon_fc)
        kleagueTeamList.add(R.drawable.img_jeju_united)
        kleagueTeamList.add(R.drawable.img_incheon_united)
        kleagueTeamList.add(R.drawable.img_jeonbuk_hundai)
        kleagueTeamList.add(R.drawable.img_daejeonhana_citizen)
        kleagueTeamList.add(R.drawable.img_suwon_bluewings)
        kleagueTeamList.add(R.drawable.img_pohang_steelers)
        kleagueTeamList.add(R.drawable.img_ulsan_hundai)

        teamList = kleagueTeamList

    }

//    private fun test

    private fun setToSoccerLeague() {
        leagueSelectedList.clear()
        leagueAdapter.initPreviousSelected()
        leagueSelectedList.add(true)
        repeat(8) {
            leagueSelectedList.add(false)
        }
        leagueAdapter = LeagueAdapter(soccerLeagueList, leagueSelectedList, this.requireContext())
        leagueRecyclerView.adapter = leagueAdapter
        leagueAdapter.notifyDataSetChanged()

        teamAdapter = LeagueTeamAdapter(kleagueTeamList, this.requireContext())
        teamRecyclerView.adapter = teamAdapter
        teamAdapter.notifyDataSetChanged()

        setTeamAdapterListener()
    }

    private fun setToBasketLeague() {
        leagueSelectedList.clear()
        leagueAdapter.initPreviousSelected()
        leagueSelectedList.add(true)
        repeat(2) {
            leagueSelectedList.add(false)
        }
        leagueAdapter = LeagueAdapter(basketLeagueList, leagueSelectedList, this.requireContext())
        leagueRecyclerView.adapter = leagueAdapter
        leagueAdapter.notifyDataSetChanged()

        teamAdapter = LeagueTeamAdapter(kblTeamList, this.requireContext())
        teamRecyclerView.adapter = teamAdapter
        teamAdapter.notifyDataSetChanged()

        setTeamAdapterListener()

    }

    private fun addExampleData() {
        sportsList.clear()
        sportsSelectedList.clear()
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

        soccerLeagueList.clear()
        leagueSelectedList.clear()
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

        basketLeagueList.clear()
        basketLeagueList.add("KBL")
        basketLeagueList.add("WKBL")
        basketLeagueList.add("NBA")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}