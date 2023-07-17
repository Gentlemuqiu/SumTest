package com.example.modle_playground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modle.playground.R
import com.example.modle.playground.databinding.FragmentPlayGroundBinding

class PlayGroundFragment : Fragment() {
    private val mBinding: FragmentPlayGroundBinding by lazy{
        FragmentPlayGroundBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return mBinding.root
    }

}