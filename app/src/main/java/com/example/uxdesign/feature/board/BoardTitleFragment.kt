package com.example.uxdesign.feature.board

import android.os.Bundle
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
        boardList.add(PostTitle("게시글 제목", "11/28", "오후 5:54", "작성자"))
        boardList.add(PostTitle("게시글 제목", "11/28", "오후 5:54", "작성자"))
        boardList.add(PostTitle("게시글 제목", "11/28", "오후 5:54", "작성자"))
        boardList.add(PostTitle("게시글 제목", "11/28", "오후 5:54", "작성자"))
        boardList.add(PostTitle("게시글 제목", "11/28", "오후 5:54", "작성자"))
        boardList.add(PostTitle("게시글 제목", "11/28", "오후 5:54", "작성자"))

        setLayoutManager()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}