package com.example.uxdesign.feature.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uxdesign.R
import com.example.uxdesign.databinding.FragmentKgcTeamBinding

class KgcTeamFragment : Fragment() {
    private var _binding : FragmentKgcTeamBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKgcTeamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivKgcPlayer.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fcv_main, KgcPlayerFragment::class.java.newInstance()).addToBackStack(null).commit()
        }

        binding.ivKgcPlayer2.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fcv_main, KgcPlayerFragment::class.java.newInstance()).addToBackStack(null).commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}