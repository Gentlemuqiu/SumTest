package com.example.model.introduce.net

import com.example.model.introduce.RelatedCategory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface getRelatedCategory {
    @GET("api/v1/tag/videos?")
    fun getRelatedCategory(@Query("id") id: Int): Call<RelatedCategory>
}