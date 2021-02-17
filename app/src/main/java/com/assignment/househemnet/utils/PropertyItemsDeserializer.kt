package com.assignment.househemnet.utils

import com.assignment.househemnet.properties.Area
import com.assignment.househemnet.properties.Item
import com.assignment.househemnet.properties.ItemTypes
import com.assignment.househemnet.properties.Property
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class PropertyItemsDeserializer:JsonDeserializer<Item> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Item? {
        return when (json?.asJsonObject?.get("type")?.asString) {
            ItemTypes.Property.name -> context?.deserialize(json, Property::class.java)
            ItemTypes.HighlightedProperty.name -> context?.deserialize(json, Property::class.java)
            ItemTypes.Area.name -> context?.deserialize(json, Area::class.java)
            else -> null
        }
    }
}
