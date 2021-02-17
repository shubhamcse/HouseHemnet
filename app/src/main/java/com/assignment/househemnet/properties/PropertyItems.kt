package com.assignment.househemnet.properties


import com.google.gson.annotations.SerializedName

data class PropertyItems(

    @SerializedName("items")
    val items: List<Item>
)
