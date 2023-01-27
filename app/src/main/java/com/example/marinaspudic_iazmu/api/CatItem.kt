package com.example.marinaspudic_iazmu.api

import com.google.gson.annotations.SerializedName

data class CatItem(

    @SerializedName("length") val length : String,
    @SerializedName("origin") val origin : String,
    @SerializedName("image_link") val image_link : String,
    @SerializedName("family_friendly") val family_friendly : Int,
    @SerializedName("shedding") val shedding : Int,
    @SerializedName("general_health") val general_health : Int,
    @SerializedName("playfulness") val playfulness : Int,
    @SerializedName("children_friendly") val children_friendly : Int,
    @SerializedName("grooming") val grooming : Int,
    @SerializedName("intelligence") val intelligence : Int,
    @SerializedName("other_pets_friendly") val other_pets_friendly : Int,
    @SerializedName("min_weight") val min_weight : Int,
    @SerializedName("max_weight") val max_weight : Int,
    @SerializedName("min_life_expectancy") val min_life_expectancy : Int,
    @SerializedName("max_life_expectancy") val max_life_expectancy : Int,
    @SerializedName("name") val name : String

)
