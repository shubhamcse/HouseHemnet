package com.assignment.househemnet.propertiesList

sealed class ItemTypes(val name:String) {
    object Area : ItemTypes("Area")
    object Property : ItemTypes("Property")
    object HighlightedProperty : ItemTypes("HighlightedProperty")
}
