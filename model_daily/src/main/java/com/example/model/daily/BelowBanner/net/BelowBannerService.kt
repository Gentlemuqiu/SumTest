package com.example.model.daily.BelowBanner.net

import com.example.model.daily.BelowBanner.net.model.BelowStory
import retrofit2.Call
import retrofit2.http.GET

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/24 17:37
 */
interface BelowBannerService {
    @GET("api/v5/index/tab/allRec?page=4&isTag=true&adIndex=3")
    fun getBelowBannerStory() : Call<BelowStory>
}