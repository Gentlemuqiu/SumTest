package com.example.model.daily.net

import com.example.model.daily.net.model.Story
import retrofit2.Call
import retrofit2.http.GET

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/20 15:10
 */
interface  BannerService {
    @GET("api/v5/index/tab/feed")
    fun getBannerStory():Call<Story>
}