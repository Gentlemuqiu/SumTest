package com.example.modle_recommended.net

import retrofit2.Call
import retrofit2.http.GET
import com.example.modle_recommended.model.recommend

interface RecommendService {
    @GET("v5/index/tab/allRec")
    suspend fun getRecommend() : Call<recommend>
}