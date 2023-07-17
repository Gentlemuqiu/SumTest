package com.example.modle_recommended.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modle_recommended.R
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.modle_recommended.adapter.recommendAdapter
import com.example.modle_recommended.viewModel.RecommendViewModel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
class RecommendActivity : AppCompatActivity() {
    lateinit var adapter: recommendAdapter
    private val viewModel by viewModels<RecommendViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lifecycleScope.launch {
            viewModel.setRecommend()
        }
        applicationContext?.let {
            viewModel.recommendList.observe(this, {
                  adapter= recommendAdapter(it)
            })
        }
        findViewById<RecyclerView>(R.id.recyclerView).also {
            it.layoutManager = LinearLayoutManager(applicationContext)
            it.adapter=adapter
        }
    }
}