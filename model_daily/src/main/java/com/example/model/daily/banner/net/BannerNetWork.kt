package com.example.model.daily.banner.net

import com.example.lib.network.ServiceCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


/**
 *author：石良昊
 *email：904839562@qq.com
date : 2023/7/20 15:09
 */
object BannerNetWork {
    private val bannerService = ServiceCreator.create<BannerService>()
    suspend fun getBannerStory() = bannerService.getBannerStory().await()

    private suspend fun <T> Call<T>.await(): T {
        //suspendCoroutine函数必须在协程作用域或挂起函数中才能调用,主要作用是将当前协程立即挂起,然后在一个普通线程中执行Lambda表达式中代码.
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    //让协程恢复
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}