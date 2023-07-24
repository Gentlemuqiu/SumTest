package com.example.modle_playground.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modle_playground.Bean.MessageBean
import com.example.modle_playground.net.PlayGroundNet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MoreMessageViewModel() : ViewModel() {
    private val _moreMessageData = MutableLiveData<MessageBean>()
    val moreMessageData: LiveData<MessageBean> get() = _moreMessageData
    fun getMoreMessageData(url: String) {
        viewModelScope.launch {
            flow {
                val list = PlayGroundNet.getMoreMessage(url)
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                    Log.d("hui", "getCateGory: ${e}")
                }
                .collect {
                    _moreMessageData.value = it
                }
        }
    }
}