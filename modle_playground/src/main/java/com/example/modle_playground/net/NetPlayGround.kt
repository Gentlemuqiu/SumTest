package com.example.modle_playground.net

import com.example.lib.network.ServiceCreator
import retrofit2.await

object NetPlayGround {
    private val followService = ServiceCreator.create<FollowService>()
    suspend fun getFollow() = followService.getFollow().await()
}