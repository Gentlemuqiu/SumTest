package com.example.modle_recommended.viewModel

import androidx.lifecycle.viewModelScope
import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.modle_recommended.model.recommend
import com.example.modle_recommended.net.RecommendNetWork
import com.example.modle_recommended.net.RecommendNetWork.getRecommend
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.await

class RecommendViewModel(app: Application) : androidx.lifecycle.AndroidViewModel(app) {

    val recommendList = MutableLiveData<recommend>()
    fun setRecommend() {
        viewModelScope.launch {
            flow {
                val list = getRecommend()
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e -> e.printStackTrace() }
                .collect {
                    recommendList.setValue(it)
                }
        }
    }
}
