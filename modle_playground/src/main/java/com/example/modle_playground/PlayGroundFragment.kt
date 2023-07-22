package com.example.modle_playground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lib.api.Page3Change
import com.example.lib.api.PageChange
import com.example.modle.playground.databinding.FragmentPlayGroundBinding
import com.example.modle_playground.ChildFragment.CateFragment
import com.example.modle_playground.ChildFragment.FollowFragment
import com.example.modle_playground.ChildFragment.RecommendFragment
import com.example.modle_playground.ChildFragment.MessageFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PlayGroundFragment : Fragment() {
    private val mBinding: FragmentPlayGroundBinding by lazy {
        FragmentPlayGroundBinding.inflate(layoutInflater)
    }
    private var nameList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData();
    }

    private fun initData() {
        mBinding.vp2Context.isUserInputEnabled=true
        mBinding.vp2Context.isSaveEnabled = false
        mBinding.vp2Context.setPageTransformer(Page3Change())
        nameList.add("关注")
        nameList.add("分类")
        nameList.add("专题")
        nameList.add("推荐")
        val adapter = PlayGroundAdapter(childFragmentManager, lifecycle)
        val followFragment = FollowFragment()
        val cateFragment = CateFragment()
        val messageFragment = MessageFragment()
        val recommendFragment=RecommendFragment()
        adapter.addFragment(followFragment)
        adapter.addFragment(cateFragment)
        adapter.addFragment(messageFragment)
        adapter.addFragment(recommendFragment)
        mBinding.vp2Context.adapter = adapter
        TabLayoutMediator(
            mBinding.tlTab, mBinding.vp2Context
        ) { tab: TabLayout.Tab, position: Int -> tab.text = nameList[position] }.attach()
    }

}