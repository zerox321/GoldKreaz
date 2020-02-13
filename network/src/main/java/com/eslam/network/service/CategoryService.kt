package com.eslam.network.service

import com.eslam.entity.response.CategoryResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryService {


    @GET("index.php")
    fun getCategoriesAsync(
        @Query("mode") mode: String,
        @Query("type") type: String
    ): Deferred<CategoryResponse>
}
