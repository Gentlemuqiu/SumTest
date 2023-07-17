package com.example.model.hot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.model.hot.databinding.FragmentHotBinding

class HotFragment : Fragment() {
    private val mBinding: FragmentHotBinding by lazy{
        FragmentHotBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return mBinding.root
    }
}