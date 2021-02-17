package com.assignment.househemnet.propertiesList

import com.google.gson.annotations.SerializedName

data class Property (
    @SerializedName("area")
    val area: String,
    @SerializedName("askingPrice")
    val askingPrice: String,
    @SerializedName("daysOnHemnet")
    val daysOnHemnet: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("livingArea")
    val livingArea: Int,
    @SerializedName("monthlyFee")
    val monthlyFee: String,
    @SerializedName("municipality")
    val municipality: String,
    @SerializedName("numberOfRooms")
    val numberOfRooms: Int,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("streetAddress")
    val streetAddress: String,
    var type: String,
) : Item

