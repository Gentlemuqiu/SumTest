package com.example.model.daily.BelowBanner.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.model.daily.BelowBanner.net.model.BelowStory
import com.example.model.daily.R
import java.lang.NullPointerException

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/24 17:53
 */
class BelowBannerAdapter(private val fragment: Fragment, private val data: ArrayList<BelowStory.Item>):
    RecyclerView.Adapter<BelowBannerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val belowStoryImage: ImageView = view.findViewById(R.id.belowStoryImage)
        val belowStoryTitle: TextView = view.findViewById(R.id.belowStoryTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.belowbanner_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
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
                if (position% data.size == 0 || position% data.size == 3) {
                    Glide.with(fragment)
                        .load(data[position % data.size].data.content.data.cover.feed)
                        .into(holder.belowStoryImage)
                    holder.belowStoryTitle.text = data[position % data.size].data.content.data.title
                } else {
                    Glide.with(fragment)
                        .load(data[position % data.size].data.cover.feed)
                        .into(holder.belowStoryImage)
                    holder.belowStoryTitle.text = data[position % data.size].data.title
                }
            } catch (e: NullPointerException) {
            }
//            }
        }
    }
}
