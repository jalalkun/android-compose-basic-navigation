package com.jalalkun.apiservice.module

import com.jalalkun.apiservice.UsersService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(UsersService::class.java) }
}