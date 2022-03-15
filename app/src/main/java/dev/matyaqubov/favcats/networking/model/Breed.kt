package dev.matyaqubov.favcats.networking.model

import com.google.gson.annotations.SerializedName

data class Breed(

    @field:SerializedName("Breed")
    val breed: List<BreedItem?>? = null
)

data class BreedItem(

    @field:SerializedName("id")
    val id: String="",
    @field:SerializedName("name")
    val name: String=""
    )


