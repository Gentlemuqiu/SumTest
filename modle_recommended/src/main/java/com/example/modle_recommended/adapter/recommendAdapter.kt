package com.example.modle_recommended.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.modle_recommended.R
import com.example.modle_recommended.model.recommend

class recommendAdapter(private val recommendList:List<recommend>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vp2= view.findViewById<ViewPager2>(R.id.vp2)
        val topAdapter=topRecommendAdapter(recommendList[0].itemList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_vp2, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

}