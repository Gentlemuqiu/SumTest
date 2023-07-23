package com.example.modle_playground.net

import com.example.lib.network.ServiceCreator
import retrofit2.await

object PlayGroundNet {
    private val cateGoryService = ServiceCreator.create<CateGoryService>()
    suspend fun getCategories() = cateGoryService.getCateGory().await()
}