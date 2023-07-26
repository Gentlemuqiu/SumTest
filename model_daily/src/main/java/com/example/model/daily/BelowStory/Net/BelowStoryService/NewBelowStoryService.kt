package com.example.model.daily.BelowStory.Net.BelowStoryService

import com.example.model.daily.BelowStory.Net.Model.BelowStory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/25 01:39
 */
interface NewBelowStoryService {
    @GET
    fun getNewBelowStory(@Url url: String): Call<BelowStory>
}