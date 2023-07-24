package com.example.model.introduce.net

import com.example.model.introduce.RelatedCategory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface NewCategoryService {
    @GET
    fun getCateGoryData(@Url url: String): Call<RelatedCategory>
}