package com.example.uxdesign.feature.category

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R

class LeagueTeamAdapter (private val items: ArrayList<Int>, val context: Context) :
    RecyclerView.Adapter<LeagueTeamAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: LeagueTeamAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item)

//        holder.itemView.setOnClickListener {
//            itemClickListener?.OnItemClick(items[position], position)
//        }

    }

    interface OnItemClickListener {
        fun onItemClick(data: Int, position: Int)
    }

    var itemClickListener : OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueTeamAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_category_team, parent, false)
        return ViewHolder(inflatedView)
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view : View = v
        var imageView : ImageView = v.findViewById(R.id.iv_item_league_team)
        init {
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(items[adapterPosition], adapterPosition)
            }
        }
    }
}