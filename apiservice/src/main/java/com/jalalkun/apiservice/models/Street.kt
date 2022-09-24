package com.jalalkun.apiservice.models


import com.google.gson.annotations.SerializedName

data class Street(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("number")
    val number: Int? = 0
)