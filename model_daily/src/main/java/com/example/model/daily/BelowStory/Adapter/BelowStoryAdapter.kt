package com.example.model.daily.BelowStory.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.lib.api.formatNumberToTime
import com.example.model.daily.BelowStory.Net.Model.BelowStory
import com.example.model.daily.R

import java.lang.NullPointerException

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/25 01:46
 */
class BelowStoryAdapter (private val fragment: Fragment, private val data: ArrayList<BelowStory.Item>):
    RecyclerView.Adapter<BelowStoryAdapter.ViewHolder>() {

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
//            }
//            else {
//                play.setOnClickListener {
//                    getItem(absoluteAdapterPosition).run {
//                        ARouter.getInstance().build("/play/PlayActivity/")
//                            .withString("playUrl", data.playUrl)
//                            .withString("title", data.title)
//                            .withString("description", data.description)
//                            .withString("category", data.category)
//                            .withInt("shareCount", data.consumption.shareCount)
//                            .withInt("likeCount", data.consumption.realCollectionCount)
//                            .withInt("commentCount", data.consumption.replyCount)
//                            .withInt("id", data.id)
//                            .navigation(context.activity?.application?.applicationContext)
//                    }
//                }
//            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.belowstory_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//            if (position% data.size == 0 || position% data.size == 11) {


//            if (position % 22 == 0) {
//                Glide.with(fragment).load(R.drawable.openeyes)
//                    .into(holder.image)
//            }
//            if (position % 22 == 11) {
//                Glide.with(fragment).load(R.drawable.eyepotizer)
//                    .into(holder.image)
//            }
//            } else


            try {
                if (position == 0 || position ==3 ) {
                    Glide.with(fragment).load(data[position].data.content.data.cover.feed).into(holder.coverImage)
                    holder.titleText.text = data[position].data.content.data.title
                    holder.typeText.text = "#" + data[position].data.content.data.category
                    holder.timeText.text = "▶"+ formatNumberToTime(data[position].data.content.data.duration)
                }
                            else {
                    Glide.with(fragment).load(data[position].data.cover.feed).into(holder.coverImage)
                    holder.titleText.text = data[position].data.title
                    holder.typeText.text = "#" + data[position].data.category
                    holder.timeText.text = "▶"+ formatNumberToTime(data[position].data.duration)
                }
            }
            catch (e: NullPointerException) {
            }
        }
    }