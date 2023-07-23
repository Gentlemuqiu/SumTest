package com.example.model.daily.Search.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.model.daily.CustomView.BorderTextView
import com.example.model.daily.R
import com.example.model.daily.Search.net.model.KeyHot


/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/22 14:03
 */
class RvListAdapter(private val context: Fragment) : ListAdapter<KeyHot, RvListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<KeyHot>() {
        override fun areItemsTheSame(oldItem: KeyHot, newItem: KeyHot): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: KeyHot, newItem: KeyHot): Boolean {
            return oldItem == newItem
        }
    }
) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rv_tv: BorderTextView = view.findViewById(R.id.rv_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val key = getItem(position)
        holder.rv_tv.text = key[position]
    }

}