package com.example.model.search.ChildAdapter

import Share
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.example.lib.api.Page2Change
import com.example.lib.api.Page3Change
import com.example.lib.api.formatNumberToTime
import com.example.model.search.Bean.Follow
import com.example.model.search.DataDiffCallback
import com.example.model.searh.R
import org.w3c.dom.Text

class FollowAdapter() :
    ListAdapter<Follow.Item, FollowAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<Follow.Item>() {
            override fun areItemsTheSame(
                oldItem: Follow.Item,
                newItem: Follow.Item
            ): Boolean {
                return oldItem.data.header.id == newItem.data.header.id
            }

            override fun areContentsTheSame(
                oldItem: Follow.Item,
                newItem: Follow.Item
            ): Boolean {
                return oldItem.data.header.id == newItem.data.header.id
            }
        }
    ) {
    private lateinit var adapter: FollowViewPager2Adapter
    private val data: MutableList<Follow.Item> = mutableListOf()
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconImage: ImageView
        val titleTextView: TextView
        val description: TextView
        val viewPager2: ViewPager2

        init {
            view.run {
                iconImage = findViewById(R.id.iv_follow_icon)
                titleTextView = findViewById(R.id.tv_follow_title)
                description = findViewById(R.id.tv_follow_description)
                viewPager2 = findViewById(R.id.vp2_video)
            }
            viewPager2.setPageTransformer(Page2Change())
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.follow_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.run {
            getItem(position).run {
                Glide.with(itemView).load(data.header.icon).into(iconImage)
                titleTextView.text = data.header.title
                description.text = data.header.description
                adapter = FollowViewPager2Adapter(data.itemList)
                viewPager2.adapter = adapter
            }
        }
    }

}