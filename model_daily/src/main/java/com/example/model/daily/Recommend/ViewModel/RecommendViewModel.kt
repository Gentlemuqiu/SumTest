package com.example.model.daily.Recommend.ViewModel

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/24 00:08
 */
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.model.daily.Recommend.net.model.Recommend
import com.example.model.daily.Recommend.net.RecommendNetWork

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class RecommendViewModel(): ViewModel() {

    val recommendList = ArrayList<Recommend.Item>()

    private val _recommendData = MutableLiveData<Recommend>()

    val recommendData: LiveData<Recommend> get() = _recommendData

    fun getRecommend() {
        viewModelScope.launch {
            flow {
                val list = RecommendNetWork.getRecommend()
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e -> e.printStackTrace()
                    Log.d("hao", "getRecommendRecommend: ${e}")
                }.collect {
                    _recommendData.value=it
                }
        }
    }
}