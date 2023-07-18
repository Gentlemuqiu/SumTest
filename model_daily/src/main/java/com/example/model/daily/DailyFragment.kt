package com.example.model.daily

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.model.daily.databinding.FragmentDailyBinding


class DailyFragment : Fragment() {

    private val mBinding: FragmentDailyBinding by lazy{
        FragmentDailyBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }

}