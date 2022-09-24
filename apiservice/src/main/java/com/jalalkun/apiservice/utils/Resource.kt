package com.jalalkun.apiservice.utils

sealed class Resource {
    class Success<T>(val data: T) : Resource()
    class Error(val message: String) : Resource()
    object Loading : Resource()
}
