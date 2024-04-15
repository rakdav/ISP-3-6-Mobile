package com.example.viewmodelfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.firstvvewmodel.MyViewModel
import com.example.viewmodelfragment.databinding.FragmentProgressBinding


class ProgressFragment : Fragment(R.layout.fragment_progress) {
    private lateinit var binding: FragmentProgressBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentProgressBinding.inflate(layoutInflater, container, false)
        val model=ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        model.getValue().observe(viewLifecycleOwner){
            binding.progressBar.progress=it
            binding.textView.text="Status:${it}"
        }
        binding.button.setOnClickListener { model.execute() }
        return binding.root
    }
}