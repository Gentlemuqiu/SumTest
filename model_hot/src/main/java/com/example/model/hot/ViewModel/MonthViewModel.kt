package com.example.model.hot.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.hot.model.Ranking
import com.example.model.hot.net.RankingNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MonthViewModel() : ViewModel() {
    private val _monthRankingData = MutableLiveData<Ranking>()
    val monthRankingData: LiveData<Ranking> get() = _monthRankingData
    fun getMonthRanking(){
        viewModelScope.launch {
          flow{
              val list= RankingNetWork.getMonthRanking()
              emit(list)
          }.flowOn(Dispatchers.IO)
              .catch { e->e.printStackTrace() }
              .collect{
                  _monthRankingData.value=it
              }
        }
    }
}