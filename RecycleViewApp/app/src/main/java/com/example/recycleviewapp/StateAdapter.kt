package com.example.recycleviewapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewapp.databinding.ListItemBinding


class StateAdapter(val context:Context, val layout:Int, val states:MutableList<State>,
                   var onClickListener:OnStateClickListener):
    RecyclerView.Adapter<StateAdapter.ViewHolder>()
{

    interface OnStateClickListener {
        fun onStateClick(state: State?, position: Int)
    }
    private var inflater: LayoutInflater? = null
    init {
        this.inflater = LayoutInflater.from(context);
        this.onClickListener=onClickListener
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flagView: ImageView
        val nameView: TextView
        val capitalView: TextView
        init {
            val binding= view.let { ListItemBinding.bind(it) }
            flagView = binding.flag
            nameView = binding.name
            capitalView = binding.capital
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View? = inflater?.inflate(layout, parent, false)
        return ViewHolder(view!!)
    }
    override fun getItemCount(): Int {
        return states.size;
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val state = states[position]
        holder.flagView.setImageResource(state.flag)
        holder.nameView.text = state.name
        holder.capitalView.text = state.capital
        holder.itemView.setOnClickListener {
            onClickListener?.onStateClick(state, position);
        }
    }
}