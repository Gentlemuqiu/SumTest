package com.example.model.search.net

import com.example.lib.network.ServiceCreator
import retrofit2.await

object SearchNet {
    private val followService = ServiceCreator.create<FollowService>()
    suspend fun getFollow() = followService.getFollow().await()

    private val newFollowService = ServiceCreator.create<NewFollowService>()

    suspend fun getNewFollow(url: String) = newFollowService.getNewFollow(url).await()
}