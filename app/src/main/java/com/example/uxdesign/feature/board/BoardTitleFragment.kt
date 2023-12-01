package com.example.uxdesign.feature.board

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R
import com.example.uxdesign.data.News
import com.example.uxdesign.data.PostTitle
import com.example.uxdesign.databinding.FragmentBoardTitleBinding

class BoardTitleFragment : Fragment() {

    private var _binding : FragmentBoardTitleBinding? = null
    private val binding get() = _binding!!

    private var _recyclerView : RecyclerView? = null
    private val recyclerView get() = _recyclerView!!

    private val boardList = ArrayList<PostTitle>()
    private lateinit var adapter : BoardTitleAdapter

    private fun setLayoutManager() {
        val layoutManager = LinearLayoutManager(this.context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        adapter = BoardTitleAdapter(boardList, this.requireContext())
        recyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBoardTitleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /***
         * listener 달기
         */

        _recyclerView = binding.rvBoardTitleList
        boardList.clear()
        boardList.add(PostTitle("명가의 몰락", "11/28", "오후 5:54", "김안녕"))
        boardList.add(PostTitle("언더독의 반란 광주", "11/28", "오후 5:54", "이안녕"))
        boardList.add(PostTitle("현대가 더비", "11/28", "오후 5:54", "홍길동"))
        boardList.add(PostTitle("인천 ACL 첫 출전!", "11/28", "오후 5:54", "김길동"))
        boardList.add(PostTitle("축구인가 격투기인가", "11/28", "오후 5:54", "축구조아"))
        boardList.add(PostTitle("호날두 양심선언", "11/28", "오후 5:54", "해축"))
        boardList.add(PostTitle("토트넘 벤치 현황", "11/28", "오후 5:54", "토트넘"))
        boardList.add(PostTitle("다음 유로파 멤버는?", "11/28", "오후 5:54", "축잘알"))

        setLayoutManager()

        adapter.itemClickListener = object : BoardTitleAdapter.OnItemClickListener {
            override fun OnItemClick(data: PostTitle, position: Int) {
//                Log.d("uxdesign", "itemClick")
                // TO DO ~~~
//                requireActivity().supportFragmentManager.findFragmentById(R.id.fcv_main) ?: navigateTo<BoardTitleFragment>()

                val i = Intent(requireContext(), PostActivity::class.java)
                i.putExtra("title", data.title)
                i.putExtra("writer", data.writer)
                i.putExtra("date", data.date)
                i.putExtra("time", data.time)
                startActivity(i)

            }
        }

        binding.ivBoardTitleBack.setOnClickListener {
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