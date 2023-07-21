package com.example.model.daily.banner.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.daily.banner.net.BannerNetWork
import com.example.model.daily.banner.net.model.Story
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/20 15:08
 */
class BannerViewModel : ViewModel() {

    private val _bannerStoryData = MutableLiveData<Story>()


    val bannerStoryData: LiveData<Story> get() = _bannerStoryData

    fun getBannerStory() {
        viewModelScope.launch {
            flow {
                val list = BannerNetWork.getBannerStory()
                emit(list)
                Log.d("slh", "getBannerStory: ${list}")
            }.flowOn(Dispatchers.IO)
                .catch { e -> e.printStackTrace()
                    Log.d("slh", "getBannerStory: ${e}")
                }.collect {
                    _bannerStoryData.value= it
                }
        }
    }
}