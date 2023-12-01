package com.example.uxdesign.feature.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uxdesign.R
import com.example.uxdesign.databinding.FragmentFavPlayerBinding
import com.example.uxdesign.feature.category.DataPlayerFragment
import com.example.uxdesign.feature.category.DataTeamFragment
import com.example.uxdesign.feature.category.KgcPlayerFragment

class FavPlayerFragment : Fragment() {

    private var _binding : FragmentFavPlayerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cvFavPlayer1.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fcv_main, KgcPlayerFragment::class.java.newInstance()).addToBackStack(null).commit()
        }
        binding.cvFavPlayer2.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fcv_main, DataPlayerFragment::class.java.newInstance()).addToBackStack(null).commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}