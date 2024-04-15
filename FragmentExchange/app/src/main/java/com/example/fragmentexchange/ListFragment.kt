package com.example.fragmentexchange

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.fragmentexchange.databinding.FragmentListBinding


class ListFragment: Fragment() {
    private var _binding: FragmentListBinding?=null
    private val binding get() = _binding!!

    interface OnFragmentSendDataListener {
        fun onSendData(data: String)
    }

    private var fragmentSendDataListener: OnFragmentSendDataListener? = null
    private var countries = arrayOf<String?>("Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            fragmentSendDataListener = context as OnFragmentSendDataListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString()
                        + " должен реализовывать интерфейс OnFragmentInteractionListener"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val root:View=binding.root
        val countriesList = binding.countriesList
        val adapter: ArrayAdapter<String?> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1, countries
        )
        countriesList.adapter = adapter
        countriesList.setOnItemClickListener { parent, _, position, _ ->
            val selected = parent.getItemAtPosition(position) as String
            fragmentSendDataListener?.onSendData(selected);
        }
        return root
    }
}