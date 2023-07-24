package com.example.model.introduce.Adapter

import Share
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.example.lib.api.Share2
import com.example.lib.api.formatNumberToTime
import com.example.model.introduce.R
import com.example.model.introduce.RelatedCategory
import com.example.model.introduce.net.getRelatedCategory

class RelatedIntroduceAdapter(private val context: Activity) :
    ListAdapter<RelatedCategory.Item, RelatedIntroduceAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<RelatedCategory.Item>() {
            override fun areItemsTheSame(
                oldItem: RelatedCategory.Item,
                newItem: RelatedCategory.Item
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: RelatedCategory.Item,
                newItem: RelatedCategory.Item
            ): Boolean {
                return oldItem == newItem
            }
        }
    ) {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val playImage: ImageView
        val iconImage: ImageView
        val titleText: TextView
        val authorText: TextView
        val timeText: TextView
        private val shareButton: Button

        init {
            view.run {
                playImage = findViewById(R.id.rank_play)
                iconImage = findViewById(R.id.rank_icon)
                titleText = findViewById(R.id.rank_title)
                authorText = findViewById(R.id.rank_author)
                timeText = findViewById(R.id.rank_time)
                shareButton = findViewById(R.id.share)
            }
            shareButton.setOnClickListener {
                Share2(context)
            }
            playImage.setOnClickListener {
                getItem(absoluteAdapterPosition).run {
                    ARouter.getInstance().build("/play/PlayActivity/")
                        .withString("playUrl", data.content.data.playUrl)
                        .withString("title", data.content.data.title)
                        .withString("description", data.content.data.description)
                        .withString("category", data.content.data.category)
                        .withInt("shareCount", data.content.data.consumption.shareCount)
                        .withInt("likeCount", data.content.data.consumption.realCollectionCount)
                        .withInt("commentCount", data.content.data.consumption.replyCount)
                        .withInt("id", data.content.data.id)
                        .navigation()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.run {
            getItem(position).run {
                Glide.with(itemView).load(data.content.data.cover.detail).into(playImage)
                Glide.with(itemView).load(data.content.data.author.icon).into(iconImage)
                titleText.text = data.content.data.title
                authorText.text = data.content.data.author.name
                timeText.text = formatNumberToTime(data.content.data.duration)
            }
        }
    }
}
