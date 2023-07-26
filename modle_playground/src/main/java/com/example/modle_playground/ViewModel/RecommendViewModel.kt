package com.example.modle_playground.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modle_playground.Bean.MessageBean
import com.example.modle_playground.Bean.RecommendBean
import com.example.modle_playground.Bean.RelatedMessage
import com.example.modle_playground.net.PlayGroundNet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class RecommendViewModel() : ViewModel() {
    private val _recommendData = MutableLiveData<RecommendBean>()
    val recommendData: LiveData<RecommendBean> get() = _recommendData
    val recommend = MutableLiveData<List<RecommendBean.Item>>()

    fun getRecommend() {
        viewModelScope.launch {
            flow {
                val list = PlayGroundNet.getRecommend()

                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e ->
                    e.printStackTrace()
                    Log.d("hui", "getRecommend: ${e}")
                }
                .collect {
                    _recommendData.value = it
                    recommend.value=it.itemList
                }
        }
    }

    private  val _moreRecommend= MutableLiveData<RecommendBean>()
    val moreRecommend :LiveData<RecommendBean> get()=_moreRecommend
    fun getMessageData(url :String) {
        viewModelScope.launch {
            flow {
                val list = PlayGroundNet.getMoreRecommend(url)
                emit(list)
            }.flowOn(Dispatchers.IO)
                .catch { e -> e.printStackTrace()
                    Log.d("hui", "getCateGory: ${e}")}
                .collect {
                    _moreRecommend.value = it
                    val oldData = recommend.value ?: emptyList()
                    recommend.value=oldData+it.itemList
                }
        }
    }


}