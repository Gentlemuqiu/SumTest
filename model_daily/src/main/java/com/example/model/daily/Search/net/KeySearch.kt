package com.example.model.daily.Search.net


import com.example.model.daily.Search.net.model.KeyHot
import retrofit2.Call
import retrofit2.http.GET


/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/22 14:20
 */
interface KeySearch {
    @GET("api/v3/queries/hot")
    fun getKey() : Call<KeyHot>
}