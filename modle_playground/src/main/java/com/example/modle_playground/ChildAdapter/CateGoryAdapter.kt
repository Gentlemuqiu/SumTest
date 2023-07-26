package com.example.modle_playground.ChildAdapter

import android.animation.ObjectAnimator
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.example.lib.api.Utils
import com.example.modle.playground.R
import com.example.modle_playground.Bean.CateGoryBean
import com.example.modle_playground.MyImage
import com.example.modle_playground.MyImage.imageArray
import com.example.modle_playground.ShutterView

class CateGoryAdapter(private val fragment: Fragment) : ListAdapter<CateGoryBean.CateGoryBeanItem,
        CateGoryAdapter.ViewHolder>(object :
    DiffUtil.ItemCallback<CateGoryBean.CateGoryBeanItem>() {
    override fun areItemsTheSame(
        oldItem: CateGoryBean.CateGoryBeanItem,
        newItem: CateGoryBean.CateGoryBeanItem
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: CateGoryBean.CateGoryBeanItem,
        newItem: CateGoryBean.CateGoryBeanItem
    ): Boolean {
        return oldItem == newItem
    }
}) {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconImage: ImageView
        val tvCategories: TextView

        init {
            view.run {
                iconImage = findViewById(R.id.iv_icon)
                tvCategories = findViewById(R.id.tv_categories)
            }
            iconImage.setOnClickListener {
                getItem(absoluteAdapterPosition).run {
                    ARouter.getInstance().build("/introduce/IntroduceActivity/")
                        .withString("description", description)
                        .withInt("id", id)
                        .navigation(fragment.activity?.application?.applicationContext)
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
                .inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.run {
            getItem(position).run {
                Glide.with(itemView).load(imageArray[position])
                    .into(iconImage)
                tvCategories.text = name
            }
        }
    }
}