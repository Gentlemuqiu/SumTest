package com.example.model.play.net

import com.example.lib.network.ServiceCreator
import retrofit2.await

object RelatedNetWork {
    private val relatedService=ServiceCreator.create<RelatedService>()
    suspend fun getRelated(id :Int)= relatedService.getRelated(id).await()
}