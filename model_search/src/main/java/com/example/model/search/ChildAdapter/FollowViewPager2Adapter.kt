package com.example.model.search.ChildAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.example.lib.api.convertTimestampToFormattedDateTime
import com.example.model.search.Bean.Follow
import com.example.model.searh.R

class FollowViewPager2Adapter(private val list: List<Follow.Item.Data.Item>) :
    RecyclerView.Adapter<FollowViewPager2Adapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageFollowChild: ImageView
        val titleFollowChildText: TextView
        val timeFollowChildText: TextView

        init {
            view.run {
                imageFollowChild = findViewById(R.id.iv_follow_item_icon)
                titleFollowChildText = findViewById(R.id.tv_follow_item_title)
                timeFollowChildText = findViewById(R.id.tv_follow_item_time)
            }
            imageFollowChild.setOnClickListener {
                list[absoluteAdapterPosition].run{
                    ARouter.getInstance().build("/play/PlayActivity/").withString("playUrl",data.playUrl )
                    .withString("title", data.title)
                    .withString("description", data.description)
                    .withString("category", data.category)
                    .withInt("shareCount", data.consumption.shareCount)
                    .withInt("likeCount", data.consumption.realCollectionCount)
                    .withInt("commentCount", data.consumption.replyCount)
                    .withInt("id", data.id)
                    .navigation()
                }
            }
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