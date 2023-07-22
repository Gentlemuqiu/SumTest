package com.example.modle_playground.ChildAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lib.api.convertTimestampToFormattedDateTime
import com.example.modle.playground.R
import com.example.modle_playground.Bean.Follow

class FollowViewPager2Adapter(private val list: List<Follow.Item.Data.Item>) :
    RecyclerView.Adapter<FollowViewPager2Adapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageFollowChild: ImageView
        val titleFollowChildText: TextView
        val timeFollowChildText: TextView
        val clVideo: ConstraintLayout

        init {
            imageFollowChild = view.findViewById(R.id.iv_follow_item_icon)
            titleFollowChildText = view.findViewById(R.id.tv_follow_item_title)
            timeFollowChildText = view.findViewById(R.id.tv_follow_item_time)
            clVideo = view.findViewById(R.id.cl_video)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.follow_child_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.run {
            Glide.with(itemView).load(list[position].data.cover.detail).into(imageFollowChild)
            titleFollowChildText.text = list[position].data.title
            timeFollowChildText.text =
                convertTimestampToFormattedDateTime(list[position].data.releaseTime)
        }
    }
}