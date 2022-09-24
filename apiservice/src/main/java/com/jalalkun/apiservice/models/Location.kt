package com.jalalkun.apiservice.models


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("coordinates")
    val coordinates: Coordinates? = Coordinates(),
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("postcode")
    val postcode: String = "",
    @SerializedName("state")
    val state: String? = "",
    @SerializedName("street")
    val street: Street? = Street(),
    @SerializedName("timezone")
    val timezone: Timezone? = Timezone()
)