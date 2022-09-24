package com.jalalkun.apiservice

import com.jalalkun.apiservice.models.ResultProfile
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {
    @GET("api")
    suspend fun getProfile(
        @Query("results") size: Int
    ): ResultProfile
}