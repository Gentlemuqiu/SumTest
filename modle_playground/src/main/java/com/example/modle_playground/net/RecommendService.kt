package com.example.modle_playground.net

import com.example.modle_playground.Bean.RecommendBean
import com.example.modle_playground.ViewModel.RecommendViewModel
import retrofit2.Call
import retrofit2.http.GET

interface RecommendService {
    @GET("api/v7/community/tab/rec")
    fun getRecommend(): Call<RecommendBean>
}