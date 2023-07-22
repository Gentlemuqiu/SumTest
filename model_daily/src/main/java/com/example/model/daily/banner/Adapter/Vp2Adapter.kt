package com.example.model.daily.banner.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.model.daily.R
import com.example.model.daily.net.model.Story

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/22 09:56
 */
class Vp2Adapter(private val fragment: Fragment, private val data: ArrayList<Story.Item>):
    RecyclerView.Adapter<Vp2Adapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.vp2_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if ( position == 0 || position == 11){

        }
        else if(position == 21){
            Glide.with(fragment).load(data[1].data.content.data.cover.feed).into(holder.image)
            holder.title.text = data[1].data.content.data.title}
        else {
            Glide.with(fragment).load(data[position].data.content.data.cover.feed).into(holder.image)
            holder.title.text = data[position].data.content.data.title
        }
    }
}