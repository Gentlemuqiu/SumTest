package com.example.model.play.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.play.Related
import com.example.model.play.net.RelatedNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class RelatedViewModel() : ViewModel() {
    private val _relatedData = MutableLiveData<Related>()
    val relatedData: LiveData<Related> get() = _relatedData
    fun getRelated(id : Int){
        viewModelScope.launch {
            flow{
                val list= RelatedNetWork.getRelated(id)
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e->e.printStackTrace()
                    Log.d("hui", "getMonthRanking:${e} ")
                }
                .collect{
                    _relatedData.value=it
                }
        }
    }
}