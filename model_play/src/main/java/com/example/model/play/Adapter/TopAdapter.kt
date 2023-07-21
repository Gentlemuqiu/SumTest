package com.example.model.play.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lib.api.formatNumberToTime
import com.example.model.play.PlayActivity
import com.example.model.play.R
import com.example.model.play.Related

class TopAdapter(
    private val title: String,
    private val description: String,
    private val category: String,
    private val shareCount: Int,
    private val likeCount: Int,
    private val commentCount: Int,
    var list: List<Related.Item>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class TopViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val topTitleTV: TextView
        val categoryTV: TextView
        val descriptionTV: TextView
        val likeTV: TextView
        val shareTV: TextView
        val commentTV: TextView

        init {
            view.run {
                topTitleTV = findViewById(R.id.tv_play_title)
                categoryTV = findViewById(R.id.tv_play_category)
                descriptionTV = findViewById(R.id.tv_play_description)
                likeTV = findViewById(R.id.tv_play_like)
                shareTV = findViewById(R.id.tv_play_share)
                commentTV = findViewById(R.id.tv_play_comment)
            }
        }
    }

    inner class BottomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val coverIV: ImageView
        val timeTV: TextView
        val titleTV: TextView
        val categoryTV: TextView
        val relatedCL: ConstraintLayout

        init {
            view.run {
                coverIV = findViewById(R.id.iv_cover)
                timeTV = findViewById(R.id.tv_time)
                titleTV = findViewById(R.id.tv_title)
                categoryTV = findViewById(R.id.tv_category)
                relatedCL = findViewById(R.id.cl_related)
            }
            relatedCL.setOnClickListener {
                val intent = Intent(view.context, PlayActivity::class.java)
                list!![absoluteAdapterPosition - 1].run {
                    intent.putExtra("playUrl", data.playUrl)
                    intent.putExtra("title", data.title)
                    intent.putExtra("description", data.description)
                    intent.putExtra("category", data.category)
                    intent.putExtra("shareCount", data.consumption.shareCount)
                    intent.putExtra("likeCount", data.consumption.realCollectionCount)
                    intent.putExtra("commentCount", data.consumption.replyCount)
                    intent.putExtra("id", data.id)
                }
                view.context.startActivity(intent)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position != 0) return 1
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            TopViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.play_top_item, parent, false)
            )
        } else {
            BottomViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.related_item, parent, false)
            )
        }


    }

    override fun getItemCount(): Int = (list?.size?.plus(1)) ?: 1

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        if (holder.itemViewType == 1 && list != null) {
            holder as BottomViewHolder
            holder.run {
                Glide.with(itemView).load(list!![position - 1].data.cover.detail)
                    .into(coverIV)
            }
        } else if (holder.itemViewType == 0) {
            holder as TopViewHolder
            holder.run {
                topTitleTV.text = title
                categoryTV.text = category
                descriptionTV.text = description
                likeTV.text = likeCount.toString()
                shareTV.text = shareCount.toString()
                commentTV.text = commentCount.toString()
            }
        }
      /*  when (holder) {
            is TopViewHolder -> {
                holder.run {
                    topTitleTV.text = title
                    categoryTV.text = category
                    descriptionTV.text = description
                    likeTV.text = likeCount.toString()
                    shareTV.text = shareCount.toString()
                    commentTV.text = commentCount.toString()
                }
            }

            is BottomViewHolder -> {
                if (list != null) {
                    holder.run {
                        Glide.with(itemView).load(list!![position - 1].data.cover.detail)
                            .into(coverIV)
                        timeTV.text = formatNumberToTime(list!![position - 1].data.duration)
                        titleTV.text = list!![position - 1].data.title
                        categoryTV.text = list!![position - 1].data.category
                    }
                }
            }
        }*/
    }
}