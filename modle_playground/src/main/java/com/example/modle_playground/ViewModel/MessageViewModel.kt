package com.example.modle_playground.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modle_playground.Bean.CateGoryBean
import com.example.modle_playground.Bean.MessageBean
import com.example.modle_playground.net.PlayGroundNet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MessageViewModel(): ViewModel() {
    private val _messageData = MutableLiveData<MessageBean>()
    val messageData: LiveData<MessageBean> get() = _messageData
    fun getMessageData() {
        viewModelScope.launch {
            flow {
                val list = PlayGroundNet.getMessage()
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e -> e.printStackTrace()
                    Log.d("hui", "getCateGory: ${e}")}
                .collect {
                    _messageData.value = it
                }
        }
    }

}