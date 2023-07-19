package com.example.model.hot.ChildFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.model.hot.ChildAdapter.RankAdapter
import com.example.model.hot.ViewModel.WeekViewModel
import com.example.model.hot.databinding.FragmentWeekBinding

class WeekFragment : Fragment() {
    private val mBinding: FragmentWeekBinding by lazy {
        FragmentWeekBinding.inflate(layoutInflater)
    }
    private val weekViewModel by lazy { ViewModelProvider(this)[WeekViewModel::class.java] }
    private lateinit var adapter: RankAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RankAdapter(this)
        weekViewModel.getWeekRanking()
        doRefresh()
        weekViewModel.weekRankingData.observe(viewLifecycleOwner) {
            adapter.submitList(it.itemList)
        }
        mBinding.rvWeek.layoutManager = LinearLayoutManager(context)
        mBinding.rvWeek.adapter = adapter
    }

    private fun doRefresh() {
        mBinding.swipeRefresh.setOnRefreshListener {
            //刷新时,再次请求一次数据
            weekViewModel.getWeekRanking()
            //将刷新状态取消
            mBinding.swipeRefresh.isRefreshing = false
            activity
        }
    }

}