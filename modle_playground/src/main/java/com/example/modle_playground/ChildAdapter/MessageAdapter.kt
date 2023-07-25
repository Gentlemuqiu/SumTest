package com.example.modle_playground.ChildAdapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.modle.playground.R
import com.example.modle_playground.Bean.MessageBean
import com.example.modle_playground.Bean.RelatedMessage
import com.example.modle_playground.ViewModel.RelatedMessageViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog

class MessageAdapter(private val fragment: Fragment) :
    ListAdapter<MessageBean.Item, MessageAdapter.ViewHolder>(
        object :
            DiffUtil.ItemCallback<MessageBean.Item>() {
            override fun areItemsTheSame(
                oldItem: MessageBean.Item,
                newItem: MessageBean.Item
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: MessageBean.Item,
                newItem: MessageBean.Item
            ): Boolean {
                return oldItem == newItem
            }
        }
    ) {
    private val relatedMessage by lazy {
        ViewModelProvider(fragment)[RelatedMessageViewModel::class.java]
    }
    private lateinit var bottomSheetDialog: BottomSheetDialog

    private lateinit var bottomSheetView: View

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ib_topic: ImageButton

        init {

            // 创建 BottomSheetDialog 对象
            bottomSheetDialog = BottomSheetDialog(fragment.requireContext())

            // 设置底部对话框的布局
            bottomSheetView = LayoutInflater.from(fragment.requireContext())
                .inflate(R.layout.message_item, null)
            bottomSheetDialog.setContentView(bottomSheetView)
            view.run {
                ib_topic = findViewById(R.id.ib)
            }
            ib_topic.setOnClickListener {
                getItem(absoluteAdapterPosition).run {
                    relatedMessage.getRelatedMessage(data.id)
                }
                relatedMessage.relatedMessage.observe(fragment.viewLifecycleOwner) {
                    val list = it
                    showBottomSheetDialog(list)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.message_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }


    private fun showBottomSheetDialog(itemList: RelatedMessage) {


        // 可以设置对话框外部是否可点击取消
        bottomSheetDialog.setCancelable(true)

        // 设置对话框的监听器（可选）
        val ivCover = bottomSheetView.findViewById<ImageView>(R.id.iv_cover)
        val rvComment = bottomSheetView.findViewById<RecyclerView>(R.id.rv_comment)
        val tvTitle = bottomSheetView.findViewById<TextView>(R.id.tv_title)
        val tvDescription = bottomSheetView.findViewById<TextView>(R.id.tv_description)
        Glide.with(fragment).load(itemList.headerImage).into(ivCover)
        tvTitle.text = itemList.brief
        tvDescription.text = itemList.text
        val adapter= MessageItemAdapter(fragment)
        adapter.submitList(itemList.itemList)
        rvComment.adapter =adapter
        rvComment.layoutManager = LinearLayoutManager(fragment.activity)
        rvComment.setOnClickListener {

            // 点击后关闭对话框
            bottomSheetDialog.dismiss()
        }

        // 显示底部对话框
        bottomSheetDialog.show()
    }
}