package com.example.model.daily.Recommend.net

import com.example.model.daily.Recommend.net.model.Recommend
import retrofit2.Call
import retrofit2.http.GET

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/23 17:49
 */
interface RecommendService {

    @GET("api/v5/index/tab/allRec?page=2&isTag=true&adIndex=3")
    fun getRecommend():Call<Recommend>
}