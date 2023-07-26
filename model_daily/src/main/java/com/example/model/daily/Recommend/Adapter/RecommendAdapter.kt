package com.example.model.daily.Recommend.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
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
                        holder.authorText.text = "#" + data[position].data.content.data.author.name
                        holder.timeText.text = "▶"+formatNumberToTime(data[position].data.content.data.duration)
                    } else {
                        Glide.with(fragment).load(data[position].data.cover.feed).into(holder.coverImage)
                        Glide.with(fragment).load(data[position].data.author.icon)
                            .transform(RoundedCorners(180)).into(holder.iconImage)
                        holder.titleText.text = data[position].data.title
                        holder.authorText.text = "#" + data[position].data.author.name
                        holder.timeText.text = "▶"+formatNumberToTime(data[position].data.duration)
                    }
                }
                catch (e: NullPointerException) {
                }
        }
    }
}