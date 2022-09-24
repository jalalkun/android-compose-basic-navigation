package com.jalalkun.apiservice.module

import com.jalalkun.apiservice.ProfileRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ProfileRepository(get()) }
}