package com.example.model.search.net

import com.example.model.search.Bean.Follow
import retrofit2.Call
import retrofit2.http.GET

interface FollowService {
    @GET("api/v4/tabs/follow")
    fun getFollow(): Call<Follow>
}