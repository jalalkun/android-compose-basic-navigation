package com.jalalkun.apiservice.models


import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("value")
    val value: Any? = Any()
)