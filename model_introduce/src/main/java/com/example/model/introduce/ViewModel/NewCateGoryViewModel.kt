package com.example.model.introduce.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.introduce.RelatedCategory
import com.example.model.introduce.net.NetIntroduce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class NewCateGoryViewModel() : ViewModel() {
    private val _newCateGoryData = MutableLiveData<RelatedCategory>()
    val newCateGoryData: LiveData<RelatedCategory> get() = _newCateGoryData
    fun getNewCateGory(url: String) {
        viewModelScope.launch {
            flow {
                val list = NetIntroduce.getNewCateGory(url)
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                    Log.d("hui", "getCateGory: ${e}")
                }
                .collect {
                    _newCateGoryData.value = it
                }
        }
    }
}