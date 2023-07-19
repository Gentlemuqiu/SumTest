package com.example.model.hot.net

import com.example.model.hot.model.Ranking
import retrofit2.Call
import retrofit2.http.GET

interface WeekService {
    @GET("api/v4/rankList/videos?strategy=weekly")
    fun getWeekRanking(): Call<Ranking>
}