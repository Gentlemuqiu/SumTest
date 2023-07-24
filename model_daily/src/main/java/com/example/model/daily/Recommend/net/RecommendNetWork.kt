package com.example.model.daily.Recommend.net

import com.example.lib.network.ServiceCreator
import retrofit2.await

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/23 17:52
 */
object RecommendNetWork {
    private val recommendService = ServiceCreator.create<RecommendService>()

    suspend fun getRecommend() = recommendService.getRecommend().await()
}