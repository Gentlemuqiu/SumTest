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
import com.example.modle.playground.R
import com.example.modle_playground.Bean.CateGoryBean
import com.example.modle_playground.MyImage.imageArray

class CateGoryAdapter(private val context: Fragment) : ListAdapter<CateGoryBean.CateGoryBeanItem,
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
                        .navigation(context.activity?.application?.applicationContext)
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
                iconImage.setImageResource(imageArray[position])
                tvCategories.text = name
            }
        }
    }
}