package com.jalalkun.apiservice.models


import com.google.gson.annotations.SerializedName

data class ResultProfile(
    @SerializedName("info")
    val info: Info = Info(),
    @SerializedName("results")
    val results: List<Profile> = listOf()
)