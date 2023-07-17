package com.example.modle_recommended.net

import retrofit2.Call
import retrofit2.http.GET
import com.example.modle_recommended.model.recommend

interface RecommendService {
    @GET("v5/index/tab/allRec?page=0")
    suspend fun getRecommend() : Call<List<recommend>>
}