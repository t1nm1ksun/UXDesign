package com.example.uxdesign.feature.category

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R

class SportsAdapter (private val items: ArrayList<String>, val selected: ArrayList<Boolean>, val context: Context) :
    RecyclerView.Adapter<SportsAdapter.ViewHolder>() {

    var previousSelected = 0

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SportsAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item

        if (selected[holder.adapterPosition]) {
            holder.itemView.setBackgroundResource(R.drawable.bg_postbackground)
        }
        else holder.itemView.setBackgroundResource(R.drawable.bg_category_team)

//        holder.itemView.setOnClickListener {
//            itemClickListener?.OnItemClick(items[position], position)
//        }

    }

    interface OnItemClickListener {
        fun onItemClick(data: String, position: Int)
    }

    var itemClickListener : OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_category_sport, parent, false)
        return ViewHolder(inflatedView)
    }

    fun initPreviousSelected() = run { previousSelected = 0 }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view : View = v
        var textView : TextView = v.findViewById(R.id.tv_item_sport_name)
        init {
            itemView.setOnClickListener {
                Log.d("uxdesign", "adapter position : $adapterPosition")
                // 클릭 시에 선택된 아이템의 인덱스를 기억하고, 아이템의 배경색을 변경
                selected[previousSelected] = false
                selected[adapterPosition] = true
                itemClickListener?.onItemClick(items[adapterPosition], adapterPosition)
                notifyItemChanged(previousSelected)
                notifyItemChanged(adapterPosition)
                previousSelected = adapterPosition
//                notifyItemChanged()
            }
        }
    }
}