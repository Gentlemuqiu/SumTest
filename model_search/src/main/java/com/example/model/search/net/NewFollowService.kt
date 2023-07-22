package com.example.model.search.net

import com.example.model.search.Bean.Follow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface NewFollowService {
    @GET
    fun getNewFollow(@Url url: String): Call<Follow>
}