package com.example.modle_playground.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modle_playground.Bean.Follow
import com.example.modle_playground.net.NetPlayGround
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class FollowViewModel() : ViewModel() {
    private val _followData = MutableLiveData<Follow>()
    val followData: LiveData<Follow> get() = _followData
    fun getFollow() {
        viewModelScope.launch {
            flow {
                val list = NetPlayGround.getFollow()
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                    Log.d("hui", "getAllRanking:${e} ")
                }
                .collect {
                    _followData.value = it
                }
        }
    }
}