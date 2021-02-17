package com.assignment.househemnet.properties

sealed class ItemTypes(val name:String) {
    object Area : ItemTypes("Area")
    object Property : ItemTypes("Property")
    object HighlightedProperty : ItemTypes("HighlightedProperty")
}
