package com.example.modle_playground.net

import com.example.modle_playground.Bean.MessageBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface MoreMessageService {
    @GET
    fun getMoreMessage(@Url url: String): Call<MessageBean>
}