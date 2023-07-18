package com.example.model.hot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.model.hot.ChildApapter.HotChildAdapter
import com.example.model.hot.ChildFragment.AllFragment
import com.example.model.hot.ChildFragment.MonthFragment
import com.example.model.hot.ChildFragment.WeekFragment
import com.example.model.hot.databinding.FragmentHotBinding

class HotFragment : Fragment() {
    private val mBinding: FragmentHotBinding by lazy {
        FragmentHotBinding.inflate(layoutInflater)
    }
    private var nameList=ArrayList<String>()
    private var mFragments= ArrayList<Fragment>()
    private lateinit var mHotChildAdapter :HotChildAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData();
        mHotChildAdapter =
            HotChildAdapter(requireActivity().supportFragmentManager, mFragments, nameList)
        mBinding.vp2Content.adapter = mHotChildAdapter
        //使Fragment与TabLayout进行联动
        mBinding.tabTitle.setupWithViewPager(mBinding.vp2Content)
    }

    private fun initData() {
        nameList.add("周排行")
        nameList.add("月排行")
        nameList.add("总排行")
        val monthFragment = MonthFragment()
        val allFragment=AllFragment()
        val weekFragment=WeekFragment()
        mFragments.add(weekFragment)
        mFragments.add(monthFragment)
        mFragments.add(allFragment)

    }
}