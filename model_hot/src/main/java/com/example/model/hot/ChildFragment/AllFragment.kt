package com.example.model.hot.ChildFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.model.hot.ChildAdapter.RankAdapter
import com.example.model.hot.R
import com.example.model.hot.ViewModel.AllViewModel
import com.example.model.hot.ViewModel.WeekViewModel
import com.example.model.hot.databinding.FragmentAllBinding
import com.example.model.hot.databinding.FragmentWeekBinding

class AllFragment : Fragment() {
    private val mBinding: FragmentAllBinding by lazy {
        FragmentAllBinding.inflate(layoutInflater)
    }
    private val allViewModel by lazy { ViewModelProvider(this)[AllViewModel::class.java] }
    private lateinit var adapter: RankAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RankAdapter(this)
        allViewModel.getAllRanking()
        doRefresh()
        allViewModel.allRankingData.observe(viewLifecycleOwner) {
            adapter.submitList(it.itemList)
        }
        mBinding.rvAll.layoutManager = LinearLayoutManager(context)
        mBinding.rvAll.adapter = adapter
    }

    private fun doRefresh() {
        mBinding.swipeRefresh3.setOnRefreshListener {
            //刷新时,再次请求一次数据
            allViewModel.getAllRanking()
            //将刷新状态取消
            mBinding.swipeRefresh3.isRefreshing = false
        }
    }

}