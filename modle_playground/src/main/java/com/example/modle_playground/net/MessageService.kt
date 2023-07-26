package com.example.modle_playground.net

import com.example.modle_playground.Bean.CateGoryBean
import com.example.modle_playground.Bean.MessageBean

import retrofit2.Call

import retrofit2.http.GET

interface MessageService {
    @GET("api/v3/specialTopics")
    fun getMessage(): Call<MessageBean>
}