package com.example.uxdesign.feature.board

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R
import com.example.uxdesign.data.PostTitle

class BoardTitleAdapter (private val items: ArrayList<PostTitle>, val context: Context)
    : RecyclerView.Adapter<BoardTitleAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardTitleAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_board_title, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: BoardTitleAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.titleTv.text = item.title
        holder.whenTv.text = "${item.date} ${item.time}"
        holder.writerTv.text = item.writer
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view : View = v
        var titleTv : TextView
        var whenTv : TextView
        var writerTv : TextView
        init {
            titleTv = v.findViewById(R.id.tv_board_title_item_title)
            whenTv = v.findViewById(R.id.tv_board_title_item_when)
            writerTv = v.findViewById(R.id.tv_board_title_item_writer)
        }
    }
}