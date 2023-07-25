package com.example.modle_playground.net

import com.example.modle_playground.Bean.MessageBean
import com.example.modle_playground.Bean.RecommendBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface MoreRecommend {
    @GET
    fun getMoreRecommend(@Url url: String): Call<RecommendBean>
}