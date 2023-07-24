package com.example.model.play.net

import com.example.model.play.Related
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RelatedService {
    @GET("api/v4/video/related?")
    fun getRelated(@Query("id") id: Int): Call<Related>
}