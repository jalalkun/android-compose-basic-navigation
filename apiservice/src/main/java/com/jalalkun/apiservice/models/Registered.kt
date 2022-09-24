package com.jalalkun.apiservice.models


import com.google.gson.annotations.SerializedName

data class Registered(
    @SerializedName("age")
    val age: Int? = 0,
    @SerializedName("date")
    val date: String? = ""
)