package com.example.model.daily.TopBanner.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.model.daily.R
import com.example.model.daily.TopBanner.net.model.Story

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/20 16:22
 */
class PagerAdapter(private val context: Fragment) :
    ListAdapter<Story.Item, PagerAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<Story.Item>() {
            override fun areItemsTheSame(oldItem: Story.Item, newItem: Story.Item): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Story.Item, newItem: Story.Item): Boolean {
                return oldItem == newItem
            }
        }
    ) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val storyItem = getItem(position % 22)
        if ( position == 0 || position == 11){}
        else {
            Glide.with(context).load(storyItem.data.content.data.cover.feed).into(holder.image)
            holder.title.text = storyItem.data.content.data.title
        }
    }
}



