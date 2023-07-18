package com.example.model.play.net

import com.example.lib.network.ServiceCreator

import retrofit2.await

object RecommendNetWork {
    private val recommendService = ServiceCreator.create<RecommendService>()
    suspend fun getRecommend() = recommendService.getRecommend().await()
}