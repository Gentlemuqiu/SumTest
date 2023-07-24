package com.example.modle_playground.net

import com.example.lib.network.ServiceCreator
import com.example.model.introduce.net.NewCategoryService
import retrofit2.await

object PlayGroundNet {
    private val cateGoryService = ServiceCreator.create<CateGoryService>()
    suspend fun getCategories() = cateGoryService.getCateGory().await()


    private val messageService = ServiceCreator.create<MessageService>()

    suspend fun getMessage() = messageService.getMessage().await()

    private val moreMessageService = ServiceCreator.create<MoreMessageService>()

    suspend fun getMoreMessage(url: String) = moreMessageService.getMoreMessage(url).await()

    private val relatedMessageService = ServiceCreator.create<RelatedMessageService>()

    suspend fun getRelatedMessageService(id: Int) =
        relatedMessageService.getRelatedMessageService(id).await()

}