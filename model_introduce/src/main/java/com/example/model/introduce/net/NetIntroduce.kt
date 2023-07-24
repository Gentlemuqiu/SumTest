package com.example.model.introduce.net

import com.example.lib.network.ServiceCreator
import com.example.lib.network.ServiceNewCreator
import retrofit2.await

object NetIntroduce {
    private val introduceService = ServiceCreator.create<getRelatedCategory>()
    suspend fun getIntroduce(id: Int) = introduceService.getRelatedCategory(id).await()
    private val getCategory = ServiceCreator.create<NewCategoryService>()

    suspend fun getNewCateGory(url: String) = getCategory.getCateGoryData(url).await()
}