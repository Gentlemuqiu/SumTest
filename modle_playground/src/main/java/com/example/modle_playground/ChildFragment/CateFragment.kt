package com.example.modle_playground.ChildFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.model_playground.ViewModel.CateGoryViewModel
import com.example.modle.playground.R
import com.example.modle.playground.databinding.FragmentCateBinding
import com.example.modle_playground.ChildAdapter.CateGoryAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CateFragment : Fragment() {
    private val mBinding: FragmentCateBinding by lazy {
        FragmentCateBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: CateGoryAdapter
    private val newFollowViewModel by lazy { ViewModelProvider(this)[CateGoryViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newFollowViewModel.getCateGory()
        mBinding.rvCategory.layoutManager =
            GridLayoutManager(context, 2)
        adapter = CateGoryAdapter()
        newFollowViewModel.cateGoryData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        mBinding.rvCategory.adapter = adapter

    }
}