package com.example.model.play.viewModel

import Recommend
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.play.net.RecommendNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class RecommendViewModel() : ViewModel() {
    private val _recommendData = MutableLiveData<Recommend>()
    val recommendData: LiveData<Recommend> get() = _recommendData
    fun getRecommendData() {
        viewModelScope.launch {
            flow {
                val list = RecommendNetWork.getRecommend()
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch {e -> e.printStackTrace()   }
                .collect { result ->
                    _recommendData.value = result
                }
        }
    }
}