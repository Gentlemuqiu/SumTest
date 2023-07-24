package com.example.model.daily.BelowBanner.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.daily.BelowBanner.net.BelowBannerNetWork
import com.example.model.daily.BelowBanner.net.model.BelowStory
import com.example.model.daily.TopBanner.Repository
import com.example.model.daily.TopBanner.net.BannerNetWork
import com.example.model.daily.TopBanner.net.model.Story
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/24 17:42
 */
class BelowBannerViewModel : ViewModel(){

    val belowStoryList = ArrayList<BelowStory.Item>()

    private val _belowBannerLiveData = MutableLiveData<BelowStory>()

    val belowBannerData: LiveData<BelowStory> get() = _belowBannerLiveData

    fun getBelowBannerStory() {
        viewModelScope.launch {
            flow {
                val list = BelowBannerNetWork.getBelowBannerStory()
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e -> e.printStackTrace()
                    Log.d("slh", "getBannerStory: ${e}")
                }.collect {
                    _belowBannerLiveData.value= it
                }
        }
    }
}