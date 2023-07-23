package com.example.model.daily.Search.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.model.daily.Search.net.KeyNetWork
import com.example.model.daily.Search.net.model.KeyHot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/22 14:17
 */
class KeyViewModel : ViewModel() {

    val keyHotList =KeyHot()

    private val _keyData = MutableLiveData<KeyHot>()
    val keyData: LiveData<KeyHot> get() = _keyData

    fun getKey() {
        viewModelScope.launch {
            flow {
                val list = KeyNetWork.getKey()
                emit(list)
                Log.d("slh", "getKey:${list} ")
            }.flowOn(Dispatchers.IO)
                .catch { e -> e.printStackTrace()
                }.collect {
                    _keyData.value= it
                }
        }
    }
}