package com.example.model.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
}