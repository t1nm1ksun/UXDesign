package com.example.uxdesign.feature.board

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R

class BoardListAdapter (private val items: ArrayList<String>, val context: Context)
    : RecyclerView.Adapter<BoardListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardListAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_board, parent, false)
        return ViewHolder(inflatedView)
    }

    interface OnItemClickListener {
        fun OnItemClick(data: String, position: Int /* 또 이벤트 처리에 필요한 거~ */)
    }

    var itemClickListener : OnItemClickListener? = null

    override fun onBindViewHolder(holder: BoardListAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.tv.text = item

        holder.iv.setOnClickListener {
            itemClickListener?.OnItemClick(items[position], position)
        }
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view : View = v
        var tv : TextView
        var iv : ImageView
        init {
            tv = v.findViewById(R.id.tv_board_item)
            iv = v.findViewById(R.id.iv_board_item_link)
        }

    }

}