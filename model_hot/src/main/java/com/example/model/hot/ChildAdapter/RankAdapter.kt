package com.example.model.hot.ChildAdapter

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
import com.bumptech.glide.Glide
import com.example.lib.api.formatNumberToTime
import com.example.model.hot.R
import com.example.model.hot.model.Ranking

class RankAdapter(private val context: Fragment) :
    ListAdapter<Ranking.Item, RankAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<Ranking.Item>() {
            override fun areItemsTheSame(oldItem: Ranking.Item, newItem: Ranking.Item): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Ranking.Item, newItem: Ranking.Item): Boolean {
                return oldItem == newItem
            }
        }
    ) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val playImage: ImageView = view.findViewById(R.id.rank_play)
        val iconImage: ImageView = view.findViewById(R.id.rank_icon)
        val titleText: TextView = view.findViewById(R.id.rank_title)
        val authorText: TextView = view.findViewById(R.id.rank_author)
        val timeText: TextView = view.findViewById(R.id.rank_time)
        val shareButton: Button = view.findViewById(R.id.share)

        init {
            shareButton.setOnClickListener {
                Share(context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rank = getItem(position)
        Glide.with(context).load(rank.data.cover.detail).into(holder.playImage)
        Glide.with(context).load(rank.data.author.icon).into(holder.iconImage)
        holder.titleText.text = rank.data.title
        holder.authorText.text = rank.data.author.name
        holder.timeText.text = formatNumberToTime(rank.data.duration)
    }
}