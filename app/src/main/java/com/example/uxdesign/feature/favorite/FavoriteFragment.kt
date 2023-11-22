package com.example.uxdesign.feature.favorite

import android.R
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.uxdesign.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment() {
    private var _binding : FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /***
         * listener 달기
         */

        /*var searchView: SearchView? = view.findViewById(R.id.search_view) as SearchView?
        val id: Int = searchView.getContext().getResources()
            .getIdentifier("android:id/search_src_text", null, null)
        searchView.findViewById(id).setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f) // 16sp*/


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}