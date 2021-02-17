package com.assignment.househemnet.propertiesList

import com.google.gson.annotations.SerializedName

data class Area (
    @SerializedName("averagePrice")
    val averagePrice: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("area")
    val area: String,
    @SerializedName("rating")
    val rating: String,
    var type: String,
) : Item
