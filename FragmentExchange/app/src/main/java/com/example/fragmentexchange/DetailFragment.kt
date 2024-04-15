package com.example.fragmentexchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentexchange.databinding.FragmentDetailBinding

class DetailFragment:Fragment() {
    private var _binding: FragmentDetailBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }
    fun setSelectedItem(selectedItem: String?) {
        val view =binding.detailsText
        view.text = selectedItem
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}