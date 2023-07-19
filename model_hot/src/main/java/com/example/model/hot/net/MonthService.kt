package com.example.model.hot.net

import com.example.model.hot.model.Ranking
import retrofit2.Call
import retrofit2.http.GET

interface MonthService {
    @GET("api/v4/rankList/videos?strategy=monthly")
    fun getWeekRanking(): Call<Ranking>
}