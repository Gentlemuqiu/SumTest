package com.example.model.daily.Search.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.model.daily.CustomView.BorderTextView
import com.example.model.daily.R
import com.example.model.daily.Search.net.model.KeyHot


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
        val view = LayoutInflater.from(fragment.context).inflate(R.layout.history_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rvTv.text = data[position]
    }

    override fun getItemCount(): Int = data.size
}