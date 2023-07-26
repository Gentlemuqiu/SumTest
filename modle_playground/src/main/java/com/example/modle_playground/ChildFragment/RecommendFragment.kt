package com.example.modle_playground.ChildFragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.modle.playground.databinding.FragmentRecommendBinding
import com.example.modle_playground.ChildAdapter.RecommendAdapter
import com.example.modle_playground.ViewModel.RecommendViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecommendFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecommendFragment : Fragment() {
    private val mBinding: FragmentRecommendBinding by lazy {
        FragmentRecommendBinding.inflate(layoutInflater)
    }
    private val recommendViewModel by lazy {
        ViewModelProvider(this)[RecommendViewModel::class.java]
    }
    private lateinit var adapter: RecommendAdapter

    private var url: String? = null

    private var count: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recommendViewModel.getRecommend()
        adapter = RecommendAdapter(this)
        recommendViewModel.recommendData.observe(viewLifecycleOwner) {
            url = it.nextPageUrl
        }
        recommendViewModel.recommend.observe(viewLifecycleOwner) {
            val list = it.filter { element ->
                element.type != "horizontalScrollCard"
            }
            adapter.submitList(list)
            count=list.size
        }
        mBinding.rvRecommend.adapter = adapter
        mBinding.rvRecommend.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        mBinding.rvRecommend.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                // 获取LayoutManager和Adapter
                // 获取LayoutManager和Adapter
                val layoutManager = recyclerView.layoutManager as StaggeredGridLayoutManager?
                val adapter = recyclerView.adapter

                if (layoutManager != null && adapter != null) {
                    // 获取最后一个可见item的位置
                    val lastVisibleItemPositions =
                        layoutManager.findLastVisibleItemPositions(null)
                    val lastVisibleItemPosition: Int =
                        getLastVisibleItem(lastVisibleItemPositions)

                    // 获取可见item的数量
                    val visibleItemCount = recyclerView.childCount

                    // 获取Adapter的item总数
                    val totalItemCount = adapter.itemCount

                    // 判断是否到达最后一个元素
                    if (lastVisibleItemPosition + visibleItemCount >= totalItemCount) {
                        url?.let {
                            doLoad(it)
                        }
                    }
                }
            }
        })
    }

    private fun doLoad(url: String) {
        recommendViewModel.getMessageData(url)
        recommendViewModel.moreRecommend.observe(viewLifecycleOwner) {
            this.url = it.nextPageUrl
        }
        recommendViewModel.recommend.observe(viewLifecycleOwner) {
            val list = it.filter { element ->
                element.type != "horizontalScrollCard"
            }
            adapter.submitList(list)
            adapter.notifyItemRangeChanged(count,list.size)
            count += list.size
        }

    }

    private fun getLastVisibleItem(lastVisibleItemPositions: IntArray): Int {
        var maxSize = 0
        for (position in lastVisibleItemPositions) {
            if (position > maxSize) {
                maxSize = position
            }
        }
        return maxSize
    }
}