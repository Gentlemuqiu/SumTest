package com.example.model.hot

import HotChildAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.model.hot.ChildFragment.AllFragment
import com.example.model.hot.ChildFragment.MonthFragment
import com.example.model.hot.ChildFragment.WeekFragment
import com.example.model.hot.databinding.FragmentHotBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class HotFragment : Fragment() {
    private val mBinding: FragmentHotBinding by lazy {
        FragmentHotBinding.inflate(layoutInflater)
    }
    private var nameList=ArrayList<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData();
    }

    private fun initData() {
        nameList.add("周排行")
        nameList.add("月排行")
        nameList.add("总排行")
        val adapter = HotChildAdapter(parentFragmentManager, lifecycle)
        val monthFragment = MonthFragment()
        val allFragment=AllFragment()
        val weekFragment=WeekFragment()
        adapter.addFragment(weekFragment)
        adapter.addFragment(monthFragment)
        adapter.addFragment(allFragment)
        mBinding.vp2Content.adapter=adapter
        TabLayoutMediator(
            mBinding.tabTitle, mBinding.vp2Content
        ) { tab: TabLayout.Tab, position: Int -> tab.text = nameList[position] }.attach()
    }
}