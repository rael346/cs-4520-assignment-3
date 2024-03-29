package com.cs4520.assignment3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.mvpButton.setOnClickListener {
            findNavController().navigate(R.id.MVPFragment)
        }
        binding.mvvmButton.setOnClickListener {
            findNavController().navigate(R.id.MVVMFragment)
        }

        return binding.root
    }
}