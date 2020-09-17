package com.skygrass.easyweather.logic.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse(val status: String, val place: List<Place>)

data class Place(
    val name: String,
    val location: Location,
    @SerializedName("formattd_address") val address: String //反序列化转为address
)

data class Location(val lng: String, val lat: String)
