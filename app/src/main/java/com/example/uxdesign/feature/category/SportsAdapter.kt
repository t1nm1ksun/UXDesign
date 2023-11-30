package com.example.uxdesign.feature.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R
import com.example.uxdesign.data.IsSelected

class SportsAdapter (private val items: ArrayList<IsSelected>, val context: Context) :
    RecyclerView.Adapter<SportsAdapter.ViewHolder>() {


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SportsAdapter.ViewHolder, position: Int) {
        val item = items[position]

        holder.itemView.setOnClickListener {
            itemClickListener?.OnItemClick(items[position], position)
        }

    }

    interface OnItemClickListener {
        fun OnItemClick(data: IsSelected, position: Int)
    }

    var itemClickListener : OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_category_sport, parent, false)
        return ViewHolder(inflatedView)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view : View = v
    }
}