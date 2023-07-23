package com.example.model.search

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.model.search.Bean.Follow
import com.example.model.search.viewModel.FollowViewModel
import com.example.model.search.viewModel.NewFollowViewModel
import com.example.model.searh.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private val followViewModel by lazy { ViewModelProvider(this)[FollowViewModel::class.java] }
    private val newFollowViewModel by lazy { ViewModelProvider(this)[NewFollowViewModel::class.java] }

    private lateinit var adapter: com.example.model.search.ChildAdapter.FollowAdapter
    private var url: String? = null
    private var data: MutableList<Follow.Item> = mutableListOf()
    private val mBinding: FragmentSearchBinding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return mBinding.root
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.rvFollow.layoutManager = LinearLayoutManager(context)
        adapter = com.example.model.search.ChildAdapter.FollowAdapter()
        followViewModel.getFollow()
        doRefresh()
        followViewModel.followData.observe(viewLifecycleOwner) {
            data.addAll(it.itemList)
            adapter.submitList(data)
            url = it.nextPageUrl
        }
        mBinding.rvFollow.adapter = adapter
        mBinding.rvFollow.setOnTouchListener { _, event ->
            // 获取横坐标和纵坐标的偏移量
            val deltaX = event.x - event.downTime
            val deltaY = event.y - event.downTime
            // 判断横坐标偏移量是否大于纵坐标偏移量
            Math.abs(deltaX) <= Math.abs(deltaY)
        }
        mBinding.rvFollow.addOnScrollListener(object : RecyclerView.OnScrollListener() {
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
        newFollowViewModel.getNewFollow(url)
        newFollowViewModel.newFollowData.observe(viewLifecycleOwner) {
           //修复重复添加元素而出现的bug
            for (newItem in it.itemList) {
                var exists = false
                for (existingItem in data) {
                    if (existingItem.data.header.id === newItem.data.header.id) {
                        exists = true
                        break
                    }
                }
                if (!exists) {
                    data.add(newItem)
                }
            }
            adapter.submitList(data)
            adapter.notifyItemRangeChanged(0,data.size)
            this.url = it.nextPageUrl
        }
    }

    private fun doRefresh() {
        mBinding.srFollow.setOnRefreshListener {
            //刷新时,再次请求一次数据
            followViewModel.getFollow()
            //将刷新状态取消
            mBinding.srFollow.isRefreshing = false
        }
    }
}