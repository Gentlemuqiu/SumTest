package com.example.modle_playground.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modle_playground.Bean.RelatedMessage
import com.example.modle_playground.net.PlayGroundNet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class RelatedMessageViewModel() : ViewModel() {
    private val _relatedMessageData = MutableLiveData<RelatedMessage>()
    val relatedMessage: LiveData<RelatedMessage> get() = _relatedMessageData
    fun getRelatedMessage(id: Int){
        viewModelScope.launch {
            flow {
                val list = PlayGroundNet.getRelatedMessageService(id)
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                    Log.d("hui", "getRelated: ${e}")
                }
                .collect {
                    _relatedMessageData.value = it
                }
        }
    }
}