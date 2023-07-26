package com.example.model.daily.BelowStory.Viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
date : 2023/7/25 01:52
*/
class NewBelowStoryViewModel : ViewModel(){

    val newBelowStoryList = ArrayList<BelowStory.Item>()


    private val _newBelowStoryData = MutableLiveData<BelowStory>()

    val newBelowStoryData: LiveData<BelowStory> get() = _newBelowStoryData

    fun getNewBelowStory(url :String) {
        viewModelScope.launch {
            flow {
                val list = BelowStoryNetWork.getNewBelowStory(url)
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                    Log.d("hao", "getAllRanking:${e} ")
                }
                .collect {
                    _newBelowStoryData.value = it
                }
        }
    }
}