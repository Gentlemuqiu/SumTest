package com.example.model.daily.BelowStory.Viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.daily.BelowBanner.net.BelowBannerNetWork
import com.example.model.daily.BelowStory.Net.BelowStoryNetWork.BelowStoryNetWork
import com.example.model.daily.BelowStory.Net.Model.BelowStory
import com.example.model.daily.Recommend.net.model.Recommend
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/25 01:51
 */
class BelowStoryViewModel : ViewModel() {

    val belowStoryList = ArrayList<BelowStory.Item>()


    private val _belowStoryData = MutableLiveData<BelowStory>()

    val belowStoryData: LiveData<BelowStory> get() = _belowStoryData

    fun getBelowStory() {
        viewModelScope.launch {
            flow {
                val list = BelowStoryNetWork.getBelowStory()
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                    Log.d("hao", "getAllRanking:${e} ")
                }
                .collect {
                    _belowStoryData.value = it
                }
        }
    }
}