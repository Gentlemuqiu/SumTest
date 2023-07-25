package com.example.model.daily.BelowStory.Adapter

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/25 15:25
 */
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.example.lib.api.Page2Change
import com.example.lib.api.formatNumberToTime
import com.example.model.daily.BelowStory.Net.Model.BelowStory
import com.example.model.daily.R
import java.lang.IndexOutOfBoundsException
import java.lang.NullPointerException


class BelowStoryListAdapter() :
    ListAdapter<BelowStory.Item, BelowStoryListAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<BelowStory.Item>() {
            override fun areItemsTheSame(
                oldItem: BelowStory.Item,
                newItem: BelowStory.Item
            ): Boolean {
                return oldItem.data.header.id == newItem.data.header.id
            }

            override fun areContentsTheSame(
                oldItem: BelowStory.Item,
                newItem: BelowStory.Item
            ): Boolean {
                return oldItem.data.header.id == newItem.data.header.id
            }
        }
    ) {
    private lateinit var adapter: BelowStoryAdapter
    private val data: MutableList<BelowStory.Item> = mutableListOf()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val play: ImageView
        val coverImage: ImageView
        val titleText: TextView
        val timeText: TextView
        val typeText: TextView


        init {
            view.run {
                play = findViewById(R.id.belowStory_play)
                coverImage = findViewById(R.id.belowStory_cover)
                titleText = findViewById(R.id.belowStory_title)
                timeText = findViewById(R.id.belowStory_duration)
                typeText = findViewById(R.id.belowStory_type)
            }
            play.setOnClickListener {
                data[absoluteAdapterPosition].run {
                    ARouter.getInstance().build("/play/PlayActivity/")
                        .withString("playUrl", data.playUrl)
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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.belowstory_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.run {
            try {
//                if (position % 6 == 1 || position % 6 == 4) {
//                    Glide.with(itemView).load(data[position% 6].data.content.data.cover.feed)
//                        .into(holder.coverImage)
//                    holder.titleText.text = data[position% 6].data.content.data.title
//                    holder.typeText.text = "#" + data[position% 6].data.content.data.category
//                    holder.timeText.text =
//                        "▶" + formatNumberToTime(data[position% 6].data.content.data.duration)
//                } else {
                    Glide.with(itemView).load(data[position].data.cover.feed)
                        .into(holder.coverImage)
                    holder.titleText.text = data[position].data.title
                    holder.typeText.text = "#" + data[position].data.category
                    holder.timeText.text = "▶" + formatNumberToTime(data[position].data.duration)
//                }
            } catch (e: NullPointerException) {
            }
        }
    }
}