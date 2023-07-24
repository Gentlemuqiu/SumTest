package com.example.model.daily.banner.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.model.daily.R
import com.example.model.daily.banner.net.model.Story
import java.lang.NullPointerException
import kotlin.math.log

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/22 09:56
 */
class Vp2Adapter(private val fragment: Fragment, private val data: ArrayList<Story.Item>):
    RecyclerView.Adapter<Vp2Adapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.vp2_item, parent, false)
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
                            Glide.with(fragment).load(data[position % data.size].data.content.data.cover.feed)
                                .into(holder.image)
                            holder.title.text = data[position % data.size].data.content.data.title

                }catch (e:NullPointerException){
                    Log.d("slh", "onBindViewHolder: ")
                }
//            }
        }
    }
        fun remove(position: Int) {
            data.removeAt(position);
            notifyItemRemoved(position);
            //刷新下标，不然下标就重复
            notifyItemRangeChanged(position, data.count());
        }
    }