package com.example.model.daily.Recommend.Adapter

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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.lib.api.formatNumberToTime
import com.example.model.daily.R
import com.example.model.daily.Recommend.net.model.Recommend

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/23 23:57
 */
class RecommendListAdapter(private val context: Fragment) :
    ListAdapter<Recommend.Item, RecommendListAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<Recommend.Item>() {
            override fun areItemsTheSame(
                oldItem: Recommend.Item,
                newItem: Recommend.Item
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Recommend.Item,
                newItem: Recommend.Item
            ): Boolean {
                return oldItem == newItem
            }
        }
    ) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val coverImage: ImageView
        val iconImage: ImageView
        val titleText: TextView
        val authorText: TextView
        val timeText: TextView


        init {
            view.run {
                coverImage = findViewById(R.id.recommend_cover)
                iconImage = findViewById(R.id.icon)
                titleText = findViewById(R.id.recommend_title)
                authorText = findViewById(R.id.author)
                timeText = findViewById(R.id.duration)
            }

//            coverImage.setOnClickListener {
//                getItem(absoluteAdapterPosition).run {
//                    ARouter.getInstance().build("/play/PlayActivity/")
//                        .withString("playUrl", data.playUrl)
//                        .withString("title", data.title)
//                        .withString("description",data.description)
//                        .withString("category", data.category)
//                        .withInt("shareCount", data.consumption.shareCount)
//                        .withInt("likeCount", data.consumption.realCollectionCount)
//                        .withInt("commentCount", data.consumption.replyCount)
//                        .withInt("id", data.id)
//                        .navigation(context.activity?.application?.applicationContext)
//                }
//            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.daily_recommend_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.run {
            getItem(position).run {
                try {
                    Glide.with(itemView).load(data.cover.feed).into(coverImage)
                    Glide.with(itemView).load(data.author.icon) .transform(RoundedCorners(180)).into(iconImage)
                    titleText.text = data.title
                    authorText.text = "#" + data.author.name
                    timeText.text = formatNumberToTime(data.duration)
                }
                catch (e:NullPointerException){

                }
            }
        }


    }
}