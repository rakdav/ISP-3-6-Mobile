package com.example.firstfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstfragment.databinding.FragmentContentBinding
import java.util.Date

class ContentFragment : Fragment(R.layout.fragment_content){
    private lateinit var binding:FragmentContentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentContentBinding.inflate(inflater,container,false)
        binding.updateButton.setOnClickListener {
            binding.dateTextView.text=Date().toString()
        }
        return binding.root
    }
}
