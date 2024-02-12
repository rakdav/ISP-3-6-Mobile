package com.example.countryadapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countryadapter.databinding.CountryItemBinding


//class CountryAdapter(private val context: Activity,val layout: Int, var countries: MutableList<Country>) :
//    ArrayAdapter<Country>(context, layout, countries) {
//        private var inflater: LayoutInflater? = null
//        init {
//            inflater=context.layoutInflater
//        }
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val view = inflater?.inflate(layout, null, true)
//        var binding= view?.let { CountryItemBinding.bind(it) }
//        val flagView= binding?.flag
//        val nameView = binding?.name
//        val capitalView = binding?.capital
//        val country= countries?.get(position)
//        if (country != null) {
//            flagView?.setImageResource(country.flag)
//            nameView?.text=country.name
//            capitalView?.text=country.capital
//        }
//        return view!!
//    }
//}

class CountryAdapter(private val context: Activity, private val layout: Int, private var countries: MutableList<Country>) :
    ArrayAdapter<Country>(context, layout, countries) {
    private var inflater: LayoutInflater? = null
    init {
        inflater=context.layoutInflater
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view:View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view=inflater.inflate(layout,null)
            viewHolder=ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view=convertView
            viewHolder = view.tag as ViewHolder
        }
        val state: Country = countries[position]

        viewHolder.imageView.setImageResource(state.flag)
        viewHolder.nameView.text = state.name
        viewHolder.capitalView.text = state.capital

        return view as View
    }

    private class ViewHolder(view: View) {
        var imageView: ImageView
        var nameView: TextView
        var capitalView: TextView
        init {
            val binding= view.let { CountryItemBinding.bind(it) }
            imageView = binding.flag
            nameView = binding.name
            capitalView = binding.capital
        }
    }
}