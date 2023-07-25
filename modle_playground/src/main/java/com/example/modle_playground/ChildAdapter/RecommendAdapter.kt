package com.example.modle_playground.ChildAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.example.modle.playground.R
import com.example.modle_playground.Bean.MessageBean
import com.example.modle_playground.Bean.RecommendBean

class RecommendAdapter(private val context: Fragment) :
    ListAdapter<RecommendBean.Item, RecommendAdapter.ViewHolder>(
        object :
            DiffUtil.ItemCallback<RecommendBean.Item>() {
            override fun areItemsTheSame(
                oldItem: RecommendBean.Item,
                newItem: RecommendBean.Item
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: RecommendBean.Item,
                newItem: RecommendBean.Item
            ): Boolean {
                return oldItem == newItem
            }
        }
    ) {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivRecommendCover: ImageView
        val tvRecommendTitle: TextView
        val ivRecommendIcon: ImageView
        val tvRecommendAuthor: TextView
        val ivRecommendSelect: ImageView

        init {
            view.run {
                ivRecommendIcon = findViewById(R.id.iv_recommend_icon)
                ivRecommendCover = findViewById(R.id.iv_recommend_cover)
                tvRecommendAuthor = findViewById(R.id.tv_recommend_author)
                tvRecommendTitle = findViewById(R.id.tv_recommend_title)
                ivRecommendSelect = findViewById(R.id.iv_select)
            }
            ivRecommendCover.setOnClickListener {
                getItem(absoluteAdapterPosition).run {
                    when (data.content.type) {
                        "video" -> ARouter.getInstance().build("/play/PlayActivity/")
                            .withString("playUrl", data.content.data.playUrl)
                            .withString("title", data.content.data.title)
                            .withString("description", data.content.data.description)
                            .withString("category", data.content.data.type)
                            .withInt("shareCount", data.content.data.consumption.shareCount)
                            .withInt("likeCount", data.content.data.consumption.realCollectionCount)
                            .withInt("commentCount", data.content.data.consumption.replyCount)
                            .withInt("id", data.content.data.id)
                            .navigation(context.activity?.application?.applicationContext)
                         else->ARouter.getInstance().build( "/photo/PhotoActivity/")
                             .withSerializable("list",data.content.data.urls)
                             .withTransition(R.anim.fade_out,R.anim.fade_in)
                             .navigation(context.activity?.application?.applicationContext)
                    }

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recommend_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.run {
            getItem(position).run {
                Glide.with(itemView).load(data.content.data.cover.detail).into(ivRecommendCover)
                Glide.with(itemView).load(data.content.data.owner.avatar)
                    .transform(RoundedCorners(180)).into(ivRecommendIcon)
                tvRecommendTitle.text = data.content.data.description
                tvRecommendAuthor.text = data.content.data.owner.nickname
                when (data.content.type) {
                    "video" -> ivRecommendSelect.setImageResource(R.drawable.play)

                    else -> ivRecommendSelect.setImageResource(R.drawable.camera)
                }
            }
        }
    }
}