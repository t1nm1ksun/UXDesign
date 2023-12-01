package com.example.uxdesign.feature.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R
import com.example.uxdesign.WebViewFragment
import com.example.uxdesign.data.News

class HomeNewsAdapter (private val items: ArrayList<News>, val context: Context) :
    RecyclerView.Adapter<HomeNewsAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HomeNewsAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.titleView.text = item.title
        holder.imgView.setImageResource(item.image)
    }

    interface OnItemClickListener {
        fun onItemClick(data: News, position: Int)
    }

    var itemClickListener : OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewsAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_home_news, parent, false)
        return ViewHolder(inflatedView)
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view : View = v
        var titleView : TextView = v.findViewById(R.id.tv_item_news)
        var btnView : Button = v.findViewById(R.id.btn_item_news)
        var imgView : ImageView = v.findViewById(R.id.iv_item_news)
        init {
            btnView.setOnClickListener {
                itemClickListener?.onItemClick(items[adapterPosition], adapterPosition)
            }
        }
    }
}