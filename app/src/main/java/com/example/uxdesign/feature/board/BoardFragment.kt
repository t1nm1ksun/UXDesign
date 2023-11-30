package com.example.uxdesign.feature.board

import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R
import com.example.uxdesign.databinding.FragmentBoardBinding
import com.example.uxdesign.feature.home.HomeFragment

class BoardFragment : Fragment() {
    private var _binding : FragmentBoardBinding? = null
    private val binding get() = _binding!!

    private var _recyclerView : RecyclerView? = null
    private val recyclerView get() = _recyclerView!!

    private val boardList = ArrayList<String>()
    private lateinit var adapter : BoardListAdapter

    private fun setLayoutManager() {
        val layoutManager = LinearLayoutManager(this.context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        adapter = BoardListAdapter(boardList, this.requireContext())
        recyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /***
         * listener 달기
         */

        _recyclerView = binding.rvBoardList
        boardList.clear()
        boardList.add("전체 게시판")
        boardList.add("축구 게시판")
        boardList.add("야구 게시판")
        boardList.add("농구 게시판")
        boardList.add("배구 게시판")
        boardList.add("골프 게시판")
        boardList.add("기타 게시판")

        setLayoutManager()

        adapter.itemClickListener = object : BoardListAdapter.OnItemClickListener {
            override fun OnItemClick(data: String, position: Int) {
                Log.d("uxdesign", "itemClick")
                // TO DO ~~~
//                requireActivity().supportFragmentManager.findFragmentById(R.id.fcv_main) ?: navigateTo<BoardTitleFragment>()

                val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fcv_main, BoardTitleFragment::class.java.newInstance()).addToBackStack(null).commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _recyclerView = null
    }

    private inline fun <reified T : Fragment> navigateTo() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fcv_main, T::class.java.newInstance())
            addToBackStack(null)
        }
    }
}