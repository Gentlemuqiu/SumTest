package com.example.model.hot.ChildAdapter

import Share

import android.content.Intent
import android.util.Log
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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.lib.api.formatNumberToTime
import com.example.model.hot.R
import com.example.model.hot.model.Ranking

class RankAdapter(private val context: Fragment) :
    ListAdapter<Ranking.Item, RankAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<Ranking.Item>() {
            override fun areItemsTheSame(
                oldItem: Ranking.Item,
                newItem: Ranking.Item
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Ranking.Item,
                newItem: Ranking.Item
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
                Share(context)
            }
            playImage.setOnClickListener {
                getItem(absoluteAdapterPosition).run {
                    ARouter.getInstance().build("/play/PlayActivity/")
                        .withString("playUrl", data.playUrl)
                        .withString("title", data.title)
                        .withString("description",data.description)
                        .withString("category", data.category)
                        .withInt("shareCount", data.consumption.shareCount)
                        .withInt("likeCount", data.consumption.realCollectionCount)
                        .withInt("commentCount", data.consumption.replyCount)
                        .withInt("id", data.id)
                        .navigation(context.activity?.application?.applicationContext)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.run {
            getItem(position).run {
                Glide.with(itemView).load(data.cover.detail).into(playImage)
                Glide.with(itemView).load(data.author.icon) .transform(RoundedCorners(180)
                ).into(iconImage)
                titleText.text = data.title
                authorText.text = data.author.name
                timeText.text = formatNumberToTime(data.duration)
            }
        }


    }
}
