package com.example.model.daily.TopBanner

import androidx.lifecycle.liveData
import com.example.model.daily.TopBanner.net.BannerNetWork
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/22 10:09
 */
object Repository {

    fun bannerStory() = fire(Dispatchers.IO){
        val bannerResponse = BannerNetWork.getBannerStory()
        run {
            Result.success(bannerResponse)
        }
    }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure(e)
            }
            emit(result)
        }
}