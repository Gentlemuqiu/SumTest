package com.example.model.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.model.searh.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {



    private val mBinding: FragmentSearchBinding by lazy{
        FragmentSearchBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        keyViewModel.keyData.observe(viewLifecycleOwner) { result ->
//            val data = result.getOrNull()
//            if (data != null) {
//                keyViewModel.keyHotList.clear()
//                keyViewModel.keyHotList.addAll(data)
//                adapter.notifyDataSetChanged()
//            }
//            mBinding.rv.layoutManager = LinearLayoutManager(context)
//            mBinding.rv.adapter = adapter
//        }
    }


}