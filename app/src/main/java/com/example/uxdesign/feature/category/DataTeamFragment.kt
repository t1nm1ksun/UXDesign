package com.example.uxdesign.feature.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uxdesign.R
import com.example.uxdesign.databinding.FragmentDataTeamBinding

class DataTeamFragment : Fragment() {
    private var _binding : FragmentDataTeamBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDataTeamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivSeoulPlayer.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fcv_main, DataPlayerFragment::class.java.newInstance()).addToBackStack(null).commit()
        }

        binding.ivSeoulPlayer2.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fcv_main, DataPlayerFragment::class.java.newInstance()).addToBackStack(null).commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}