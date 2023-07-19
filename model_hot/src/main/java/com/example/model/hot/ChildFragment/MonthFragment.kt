package com.example.model.hot.ChildFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.model.hot.ChildAdapter.RankAdapter
import com.example.model.hot.ViewModel.MonthViewModel
import com.example.model.hot.databinding.FragmentMonthBinding
class MonthFragment : Fragment() {
    private val mBinding: FragmentMonthBinding by lazy {
        FragmentMonthBinding.inflate(layoutInflater)
    }
    private val monthViewModel by lazy { ViewModelProvider(this)[MonthViewModel::class.java] }
    private lateinit var adapter: RankAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RankAdapter(this)
        monthViewModel.getMonthRanking()
        doRefresh()
        monthViewModel.monthRankingData.observe(viewLifecycleOwner) {
            adapter.submitList(it.itemList)
        }
        mBinding.rvMonth.layoutManager = LinearLayoutManager(context)
        mBinding.rvMonth.adapter = adapter
    }
    private fun doRefresh() {
        mBinding.swipeRefresh2.setOnRefreshListener {
            //刷新时,再次请求一次数据
            monthViewModel.getMonthRanking()
            //将刷新状态取消
            mBinding.swipeRefresh2.isRefreshing = false

        }
    }
}