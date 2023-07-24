package com.example.modle_playground.ChildAdapter

import Share
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.example.lib.api.formatNumberToTime
import com.example.modle.playground.R
import com.example.modle_playground.Bean.MessageBean
import com.example.modle_playground.Bean.RelatedMessage

class MessageItemAdapter(private val context: Fragment) :
    ListAdapter<RelatedMessage.Item, MessageItemAdapter.ViewHolder>(
        object :
            DiffUtil.ItemCallback<RelatedMessage.Item>() {
            override fun areItemsTheSame(
                oldItem: RelatedMessage.Item,
                newItem: RelatedMessage.Item
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: RelatedMessage.Item,
                newItem: RelatedMessage.Item
            ): Boolean {
                return oldItem == newItem
            }
        }

    ) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPlay: ImageView
        val tvTitle: TextView
        val tvAuthor: TextView
        val tvTime: TextView
        val ivIcon: ImageView
        private val shareButton: Button

        init {
            view.run {
                ivPlay = findViewById(R.id.rank_play)
                ivIcon = findViewById(R.id.rank_icon)
                tvTitle = findViewById(R.id.rank_title)
                tvAuthor = findViewById(R.id.rank_author)
                tvTime = findViewById(R.id.rank_time)
                shareButton = findViewById(R.id.share)
            }
            shareButton.setOnClickListener {
                Share(context)
            }
            ivPlay.setOnClickListener {
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
                        .navigation(context.activity?.application?.applicationContext)
                }
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessageItemAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageItemAdapter.ViewHolder, position: Int) {
        holder.run {
            getItem(position).run {
                Glide.with(itemView).load(data.content.data.cover.detail).into(ivPlay)
                Glide.with(itemView).load(data.content.data.author.icon).into(ivIcon)
                tvTitle.text = data.content.data.title
                tvAuthor.text = data.content.data.author.name
                tvTime.text = formatNumberToTime(data.content.data.duration)
            }
        }
    }
}