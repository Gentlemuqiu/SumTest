package com.example.model.daily.BelowStory.Net.BelowStoryNetWork

import com.example.lib.network.ServiceCreator
import com.example.model.daily.BelowStory.Net.BelowStoryService.BelowStoryService
import com.example.model.daily.BelowStory.Net.BelowStoryService.NewBelowStoryService
import retrofit2.await

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/25 01:41
 */
object BelowStoryNetWork {

    private val belowStoryService = ServiceCreator.create<BelowStoryService>()

    suspend fun getBelowStory() = belowStoryService.getBelowStory().await()

    private val newBelowStoryService = ServiceCreator.create<NewBelowStoryService>()

    suspend fun getNewBelowStory(url: String) = newBelowStoryService.getNewBelowStory(url).await()
}