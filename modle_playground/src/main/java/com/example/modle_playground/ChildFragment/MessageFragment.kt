package com.example.modle_playground.ChildFragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modle.playground.databinding.FragmentMessageBinding
import com.example.modle_playground.Bean.MessageBean
import com.example.modle_playground.ChildAdapter.MessageAdapter
import com.example.modle_playground.ViewModel.MessageViewModel


class MessageFragment : Fragment() {
    private val mBinding: FragmentMessageBinding by lazy {
        FragmentMessageBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: MessageAdapter
    private var url: String? = null

    private var data: MutableList<MessageBean.Item> = mutableListOf()

    private val messageViewModel by lazy {
        ViewModelProvider(this)[MessageViewModel::class.java]
    }
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageViewModel.getMessageData()
        mBinding.rvSpecial.layoutManager = LinearLayoutManager(context)
        adapter = MessageAdapter(this)
        messageViewModel.messageData.observe(viewLifecycleOwner) {
            url = it.nextPageUrl
        }
       messageViewModel.message.observe(viewLifecycleOwner){
           adapter.submitList(it)
           count=it.size
       }
        mBinding.rvSpecial.adapter = adapter

        mBinding.rvSpecial.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                if (totalItemCount - 1 == lastVisibleItemPosition
                    && !recyclerView.canScrollVertically(
                        1
                    )
                ) url?.let {
                    doLoad(it)
                }
            }
        })
    }

    private fun doLoad(url: String) {
        messageViewModel.getMoreMessageData(url)
        messageViewModel.moreMessageData.observe(viewLifecycleOwner) {

            this.url = it.nextPageUrl
        }

            messageViewModel.message.observe(viewLifecycleOwner){
                adapter.submitList(it)
                adapter.notifyItemRangeChanged(count, data.size)
                count+=it.size
            }

    }
}