package com.example.model.search

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    private lateinit var url: String
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
            data = it.itemList.toMutableList()
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
            //用来标记是否正在向最后一个滑动
            var isSlidingToLast = false

            @RequiresApi(Build.VERSION_CODES.O)
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                //设置什么布局管理器,就获取什么的布局管理器
                val manager = recyclerView.layoutManager as LinearLayoutManager?
                // 当停止滑动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition ,角标值
                    val lastVisibleItem = manager!!.findLastCompletelyVisibleItemPosition()
                    //所有条目,数量值
                    val totalItemCount = manager.itemCount
                    // 判断是否滚动到底部，并且是向下滚动
                    if (lastVisibleItem == totalItemCount - 1 && isSlidingToLast) {
                        //加载更多功能的代码
                        doLoad(url)
                        Toast.makeText(activity, "上拉加载成功", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                //dx>0:向右滑动,dx<0:向左滑动
                //dy>0:向下滑动,dy<0:向上滑动
                isSlidingToLast = dy > 0
            }
        })

    }

    private fun doLoad(url: String) {
        newFollowViewModel.getNewFollow(url)
        newFollowViewModel.newFollowData.observe(viewLifecycleOwner) {
            data.addAll(it.itemList)
            adapter.submitList(data)
            adapter.notifyItemRangeChanged(data.size,it.itemList.size)

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