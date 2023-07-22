package com.example.modle_playground.ChildFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modle.playground.R
import com.example.modle.playground.databinding.FragmentFllowBinding
import com.example.modle_playground.ChildAdapter.FollowAdapter
import com.example.modle_playground.viewModel.FollowViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FollowFragment : Fragment() {
    private val mBinding: FragmentFllowBinding by lazy {
        FragmentFllowBinding.inflate(layoutInflater)
    }
    private val followViewModel by lazy { ViewModelProvider(this)[FollowViewModel::class.java] }

    private lateinit var adapter: FollowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.rvFollow.layoutManager = LinearLayoutManager(context)
        adapter= FollowAdapter()
        followViewModel.getFollow()
        doRefresh()
        followViewModel.followData.observe(viewLifecycleOwner) {
            adapter.submitList(it.itemList)
        }
        mBinding.rvFollow.adapter=adapter

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