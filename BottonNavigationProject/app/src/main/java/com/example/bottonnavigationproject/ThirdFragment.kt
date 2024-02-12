package com.example.bottonnavigationproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottonnavigationproject.databinding.FragmentFirstBinding
import com.example.bottonnavigationproject.databinding.FragmentThirdBinding


class ThirdFragment : Fragment(R.layout.fragment_third) {
    private lateinit var binding: FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentThirdBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}