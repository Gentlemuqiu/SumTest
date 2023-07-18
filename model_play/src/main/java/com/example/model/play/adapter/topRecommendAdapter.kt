/*
package com.example.modle_recommended.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.modle.play.R
import com.example.modle_recommended.model.recommend

class topRecommendAdapter(private val itemList: List<recommend.Item>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.topRecommend)
        val text: TextView = view.findViewById(R.id.topTitle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.top_recommend_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int =itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
}*/
