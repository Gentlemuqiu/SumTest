package com.example.modle_playground.net

import com.example.modle_playground.Bean.CateGoryBean
import retrofit2.Call
import retrofit2.http.GET

interface CateGoryService {
    @GET("api/v4/categories")
    fun getCateGory(): Call<CateGoryBean>
}