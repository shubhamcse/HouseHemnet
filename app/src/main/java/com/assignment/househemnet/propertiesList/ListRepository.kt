package com.assignment.househemnet.propertiesList

import com.assignment.househemnet.utils.PropertyItemsDeserializer
import com.assignment.househemnet.utils.Resource
import com.google.gson.GsonBuilder

class ListRepository {

    fun getProperties(): Resource<PropertyItems> {
        return Resource.success(parseResponse(getPropertyJson()))
    }

    private fun getPropertyJson(): String {
        return "{\n" +
                "    \"items\": [{\n" +
                "            \"type\": \"HighlightedProperty\",\n" +
                "            \"id\": \"1234567890\",\n" +
                "            \"askingPrice\": \"2 650 000 kr\",\n" +
                "            \"monthlyFee\": \"1 498 kr/mån\",\n" +
                "            \"municipality\": \"Gällivare kommun\",\n" +
                "            \"area\": \"Heden\",\n" +
                "            \"daysOnHemnet\": 1,\n" +
                "            \"livingArea\": 120,\n" +
                "            \"numberOfRooms\": 5,\n" +
                "            \"streetAddress\": \"Mockvägen 1\",\n" +
                "            \"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Hus_i_svarttorp.jpg/800px-Hus_i_svarttorp.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"Property\",\n" +
                "            \"id\": \"1234567891\",\n" +
                "            \"askingPrice\": \"6 950 000 kr\",\n" +
                "            \"monthlyFee\": \"3 498 kr/mån\",\n" +
                "            \"municipality\": \"Stockholm\",\n" +
                "            \"area\": \"Nedre Gärdet\",\n" +
                "            \"daysOnHemnet\": 10,\n" +
                "            \"livingArea\": 85,\n" +
                "            \"numberOfRooms\": 3,\n" +
                "            \"streetAddress\": \"Mockvägen 2\",\n" +
                "            \"image\": \"https://upload.wikimedia.org/wikipedia/commons/8/8f/Arkitekt_Peder_Magnussen_hus_H%C3%B8nefoss_HDR.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"Area\",\n" +
                "            \"id\": \"1234567892\",\n" +
                "            \"area\": \"Stockholm\",\n" +
                "      \"rating\": \"4.5/5\",\n" +
                "            \"averagePrice\": \"50 100 kr/m2\",\n" +
                "            \"image\": \"https://i.imgur.com/v6GDnCG.png\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"Property\",\n" +
                "            \"id\": \"1234567893\",\n" +
                "            \"askingPrice\": \"1 150 000 kr\",\n" +
                "            \"monthlyFee\": \"2 298 kr/mån\",\n" +
                "            \"municipality\": \"Uppsala kommun\",\n" +
                "            \"area\": \"Kvarngärdet\",\n" +
                "            \"daysOnHemnet\": 12,\n" +
                "            \"livingArea\": 29,\n" +
                "            \"numberOfRooms\": 1,\n" +
                "            \"streetAddress\": \"Mockvägen 4\",\n" +
                "            \"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Bertha_Petterssons_hus_01.jpg/800px-Bertha_Petterssons_hus_01.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"Property\",\n" +
                "            \"id\": \"1234567894\",\n" +
                "            \"askingPrice\": \"12 490 000 kr\",\n" +
                "            \"monthlyFee\": \"5 100 kr/mån\",\n" +
                "            \"municipality\": \"Göteborgs kommun\",\n" +
                "            \"area\": \"Vasastaden\",\n" +
                "            \"daysOnHemnet\": 1,\n" +
                "            \"livingArea\": 250,\n" +
                "            \"numberOfRooms\": 7,\n" +
                "            \"streetAddress\": \"Mockvägen 5\",\n" +
                "            \"image\": \"https://upload.wikimedia.org/wikipedia/commons/f/f9/Navigat%C3%B8rernes_Hus_01.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"Property\",\n" +
                "            \"id\": \"1234567895\",\n" +
                "            \"askingPrice\": \"4 100 000 kr\",\n" +
                "            \"monthlyFee\": \"4 100 kr/mån\",\n" +
                "            \"municipality\": \"Falu kommun\",\n" +
                "            \"area\": \"Källviken\",\n" +
                "            \"daysOnHemnet\": 4,\n" +
                "            \"livingArea\": 163,\n" +
                "            \"numberOfRooms\": 5,\n" +
                "            \"streetAddress\": \"Mockvägen 6\",\n" +
                "            \"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Braskens_hus_20160717.jpg/800px-Braskens_hus_20160717.jpg\"\n" +
                "        }\n" +
                "    ]\n" +
                "}"
    }

    fun parseResponse(json: String) : PropertyItems {
        val gson = GsonBuilder()
            .registerTypeAdapter(Item::class.java, PropertyItemsDeserializer()).create()

        return gson.fromJson(json, PropertyItems::class.java)
    }


}
