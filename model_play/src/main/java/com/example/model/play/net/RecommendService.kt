package com.example.model.play.net

import com.example.model.play.model.Recommend
import retrofit2.Call
import retrofit2.http.GET

interface RecommendService {
    @GET("api/v5/index/tab/allRec")
     fun getRecommend() : Call<Recommend>
}