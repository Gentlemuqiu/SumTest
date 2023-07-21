package com.example.model.daily.banner.net

import com.example.lib.network.ServiceCreator
import retrofit2.await


/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/20 15:09
 */
object BannerNetWork {
    private val bannerService = ServiceCreator.create<BannerService>()
    suspend fun getBannerStory() = bannerService.getBannerStory().await()


}