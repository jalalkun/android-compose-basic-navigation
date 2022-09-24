package com.jalalkun.apiservice

import com.jalalkun.apiservice.utils.Resource
import retrofit2.HttpException

class ProfileRepository(private val usersService: UsersService) {
    suspend fun getProfiles(size: Int): Resource{
        return try {
            val response = usersService.getProfile(size).results
            Resource.Success(response)
        }catch (e: HttpException){
            Resource.Error("Error ${e.message()}")
        }catch (e: Exception){
            Resource.Error("Error ${e.message}")
        }
    }
}