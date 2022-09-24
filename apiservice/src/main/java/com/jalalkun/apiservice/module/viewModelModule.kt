package com.jalalkun.apiservice.module

import com.jalalkun.apiservice.ProfileViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { ProfileViewModel(get()) }
}