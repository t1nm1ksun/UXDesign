package com.example.uxdesign.feature.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.R
import com.example.uxdesign.data.News

class HomeNewsAdapter (private val items: ArrayList<News>, val context: Context) :
    RecyclerView.Adapter<HomeNewsAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HomeNewsAdapter.ViewHolder, position: Int) {
        val item = items[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewsAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_home_news, parent, false)
        return ViewHolder(inflatedView)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view : View = v
    }
}