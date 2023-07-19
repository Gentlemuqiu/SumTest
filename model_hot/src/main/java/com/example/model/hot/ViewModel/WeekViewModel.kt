package com.example.model.hot.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.hot.model.Ranking
import com.example.model.hot.net.RankingNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch



class WeekViewModel(): ViewModel() {
    private val _weekRankingData = MutableLiveData<Ranking>()
    val weekRankingData: LiveData<Ranking> get() = _weekRankingData
    fun getWeekRanking() {
        viewModelScope.launch {
            flow {
                val list = RankingNetWork.getWeekRanking()
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e -> e.printStackTrace()
                    Log.d("hui", "getWeekRanking: ${e}")
                }.collect {
                    _weekRankingData.value=it
                }
        }
    }
}