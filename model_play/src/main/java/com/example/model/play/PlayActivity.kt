package com.example.model.play

import Recommend
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.modle.play.databinding.ActivityPlayBinding
import com.example.model.play.viewModel.RecommendViewModel

class PlayActivity : AppCompatActivity() {
    private val mBinding: ActivityPlayBinding by lazy {
        ActivityPlayBinding.inflate(layoutInflater)
    }
    private val recommendViewModel by lazy { ViewModelProvider(this)[RecommendViewModel::class.java] }
    private lateinit var list: MutableList<Recommend>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        recommendViewModel.getRecommendData()

        recommendViewModel.recommendData.observe(this, Observer {
            Log.d("hui", "onCreate: ${it}")
            list.add(it)
        })
        mBinding.hello.setOnClickListener({
            Log.d("hui", "onCreate: ${list.get(0)}")
        }
        )
    }
}