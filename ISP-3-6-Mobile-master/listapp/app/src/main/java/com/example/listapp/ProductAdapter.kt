package com.example.listapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.listapp.databinding.ListItemBinding


internal class ProductAdapter(
    context: Context?,
    private val layout: Int,
    private val productList: MutableList<Product>
) :
    ArrayAdapter<Product?>(context!!, layout, productList as List<Product?>) {
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view:View
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(layout,null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view=convertView
            viewHolder = view.tag as ViewHolder
        }
        val product = productList[position]
        viewHolder.nameView.text = product.name
        viewHolder.countView.text = product.count.toString() + " " + product.unit
        viewHolder.removeButton.setOnClickListener {
            var count = product.count - 1
            if (count < 0) count = 0
            product.count = count
            viewHolder.countView.text = count.toString() + " " + product.unit
        }
        viewHolder.addButton.setOnClickListener {
            val count = product.count + 1
            product.count = count
            viewHolder.countView.text = count.toString() + " " + product.unit
        }
        return view
    }

    private class ViewHolder(view: View) {
        val addButton: Button
        val removeButton: Button
        val nameView: TextView
        val countView: TextView

        init {
            val binding= view.let { ListItemBinding.bind(it) }
            addButton = binding.addButton
            removeButton =binding.removeButton
            nameView = binding.nameView
            countView = binding.countView
        }
    }
}