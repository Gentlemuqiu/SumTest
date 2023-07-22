package com.example.modle_playground.net

import com.example.modle_playground.Bean.Follow
import retrofit2.Call
import retrofit2.http.GET

interface FollowService {
    @GET("api/v4/tabs/follow")
    fun getFollow(): Call<Follow>
}