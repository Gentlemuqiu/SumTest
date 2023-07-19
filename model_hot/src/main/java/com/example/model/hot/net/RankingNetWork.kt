package com.example.model.hot.net

import com.example.lib.network.ServiceCreator
import retrofit2.await

object RankingNetWork {
    private val rankingWeekService=ServiceCreator.create<WeekService>()
    suspend fun getWeekRanking() = rankingWeekService.getWeekRanking().await()
}