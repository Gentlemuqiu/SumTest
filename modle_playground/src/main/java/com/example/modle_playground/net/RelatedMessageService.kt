package com.example.modle_playground.net

import com.example.modle_playground.Bean.RelatedMessage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RelatedMessageService {
    @GET("api/v3/lightTopics/internal/{id}")
    fun getRelatedMessageService(@Path("id") id: Int): Call<RelatedMessage>
}