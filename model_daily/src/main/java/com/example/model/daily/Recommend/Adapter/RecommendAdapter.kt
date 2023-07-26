package com.example.model.daily.Recommend.Adapter

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
import com.example.model.daily.R
import com.example.model.daily.Recommend.net.model.Recommend
import java.lang.NullPointerException

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/24 14:06
 */
class RecommendAdapter (private val fragment: Fragment, private val data: ArrayList<Recommend.Item>):
    RecyclerView.Adapter<RecommendAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val play: ImageView
        val coverImage: ImageView
        val iconImage: ImageView
        val titleText: TextView
        val authorText: TextView
        val timeText: TextView
        val typeText: TextView


        init {
            view.run {
                play = findViewById(R.id.play)
                coverImage = findViewById(R.id.recommend_cover)
                iconImage = findViewById(R.id.icon)
                titleText = findViewById(R.id.recommend_title)
                authorText = findViewById(R.id.author)
                timeText = findViewById(R.id.recommend_duration)
                typeText = findViewById(R.id.recommend_type)
            }
            play.setOnClickListener {
                if (absoluteAdapterPosition == 0 || absoluteAdapterPosition == 3 ) {
                    data[absoluteAdapterPosition].run {
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
                }else{
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
            LayoutInflater.from(parent.context).inflate(R.layout.daily_recommend_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (data.isNotEmpty()) {
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
                    if (position == 0 || position == 3) {
                        Glide.with(fragment).load(data[position].data.content.data.cover.feed).into(holder.coverImage)
                        Glide.with(fragment).load(data[position].data.content.data.author.icon)
                            .transform(RoundedCorners(180)).into(holder.iconImage)
                        holder.titleText.text = data[position].data.content.data.title
                        holder.authorText.text =  data[position].data.content.data.author.name
                        holder.typeText.text = "#" + data[position].data.content.data.category
                        holder.timeText.text = "▶"+formatNumberToTime(data[position].data.content.data.duration)
                    } else {
                        Glide.with(fragment).load(data[position].data.cover.feed).into(holder.coverImage)
                        Glide.with(fragment).load(data[position].data.author.icon)
                            .transform(RoundedCorners(180)).into(holder.iconImage)
                        holder.titleText.text = data[position].data.title
                        holder.authorText.text =  data[position].data.author.name
                        holder.typeText.text = "#" + data[position].data.category
                        holder.timeText.text = "▶"+formatNumberToTime(data[position].data.duration)
                    }
                }
                catch (e: NullPointerException) {
                }
        }
    }
}