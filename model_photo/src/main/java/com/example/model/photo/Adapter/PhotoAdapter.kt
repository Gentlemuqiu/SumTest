package com.example.model.photo.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.model.photo.R
import com.github.chrisbanes.photoview.PhotoView

class PhotoAdapter(private val list: List<String>) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: PhotoView
        init {
            view.run {
                photo=findViewById(R.id.photoView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.run {
            Glide.with(itemView).load(list[position]).into(photo)
        }
    }
}