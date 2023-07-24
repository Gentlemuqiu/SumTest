package com.example.model.introduce.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.introduce.RelatedCategory
import com.example.model.introduce.net.NetIntroduce
import com.example.model.introduce.net.getRelatedCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class IntroduceViewModel() : ViewModel() {
    private val _relatedCategoryData = MutableLiveData<RelatedCategory>()
    val relatedCategoryData: LiveData<RelatedCategory> get() = _relatedCategoryData
    fun getRelatedCategoryData(id: Int) {
        viewModelScope.launch {
            flow {
                val list = NetIntroduce.getIntroduce(id)
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                    Log.d("hui", "getMonthRanking:${e} ")
                }
                .collect {
                    _relatedCategoryData.value = it
                }
        }
    }
}