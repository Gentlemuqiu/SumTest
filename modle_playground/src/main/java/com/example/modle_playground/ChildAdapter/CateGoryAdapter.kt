package com.example.modle_playground.ChildAdapter

import android.animation.ObjectAnimator
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib.api.MosaicView
import com.example.lib.api.Utils
import com.example.modle.playground.R
import com.example.modle_playground.Bean.CateGoryBean
import com.example.modle_playground.MyImage.imageArray

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

 private lateinit var anim :ObjectAnimator
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconImage: MosaicView
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
            anim = ObjectAnimator.ofInt(iconImage, "ratio", - 100, 100)
            anim.duration = 2000
            iconImage.setGridCount(20)
            iconImage.setOffset(5)
            anim.start()


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
                iconImage.setImageBitmap(null)
                Glide.with(fragment).asBitmap().load(imageArray[position])
                    .into(object : SimpleTarget<Bitmap>() {
                        override fun onResourceReady(
                            resource: Bitmap,
                            transition: Transition<in Bitmap>?
                        ) {
                            iconImage.setImageBitmap(resource)
                        }
                    })
                tvCategories.text = name
            }
        }
    }
}
