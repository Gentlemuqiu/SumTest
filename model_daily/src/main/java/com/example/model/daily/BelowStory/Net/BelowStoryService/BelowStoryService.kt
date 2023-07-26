package com.example.model.daily.BelowStory.Net.BelowStoryService

import com.example.model.daily.BelowStory.Net.Model.BelowStory
import retrofit2.Call
import retrofit2.http.GET

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/25 01:37
 */
interface BelowStoryService {
    @GET("api/v5/index/tab/allRec?page=1&isTag=true&adIndex=5")
    fun getBelowStory() : Call<BelowStory>
}