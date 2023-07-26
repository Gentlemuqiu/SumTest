package com.example.model.hot

import com.example.model.hot.model.Ranking

object MemoryCacheManager {
    private val memoryCache = hashMapOf<String, Ranking>()
    fun put(key: String, data: Ranking) {
        memoryCache[key] = data
    }

    fun get(key: String): Ranking? {
        return memoryCache[key]
    }

    fun remove(key: String) {
        memoryCache.remove(key)
    }
    fun clear(){
        memoryCache.clear()
    }
}