package com.example.model.search

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.model.search.Bean.Follow
import com.example.model.search.viewModel.FollowViewModel
import com.example.model.searh.R
import com.example.model.searh.databinding.FragmentSearchBinding
import java.lang.Math.abs


class SearchFragment : Fragment() {

    private val followViewModel by lazy {
        ViewModelProvider(this)[FollowViewModel::class.java]
    }

    private lateinit var adapter:
            com.example.model.search.ChildAdapter.FollowAdapter
    private var url: String? = null

    private var count: Int = 0


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
            url = it.nextPageUrl
        }
        followViewModel.follow.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            count = it.size
        }
        mBinding.rvFollow.adapter = adapter




        mBinding.rvFollow.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
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
        followViewModel.getNewFollow(url)
        followViewModel.newFollowData.observe(viewLifecycleOwner) {
            this.url = it.nextPageUrl
        }
        followViewModel.follow.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.notifyItemRangeChanged(count, it.size)
            count += it.size
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