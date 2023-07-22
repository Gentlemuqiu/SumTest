package com.example.model.daily.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.model.daily.BorderTextView
import com.example.model.daily.R
import com.example.model.daily.net.model.KeyHot


/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/22 16:18
 */
class RvAdapter(private val fragment: Fragment, private val data: KeyHot) :
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rvTv: BorderTextView = view.findViewById(R.id.rv_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(fragment.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rvTv.text = data[position]
    }

    override fun getItemCount(): Int = data.size
}