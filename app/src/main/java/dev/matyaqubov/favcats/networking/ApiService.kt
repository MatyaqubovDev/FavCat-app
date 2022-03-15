package dev.matyaqubov.favcats.networking

import dev.matyaqubov.favcats.networking.model.BreedItem
import dev.matyaqubov.favcats.networking.model.Cat
import dev.matyaqubov.favcats.networking.model.CatItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("breeds")
    fun getAllBreeds() :Call<ArrayList<BreedItem>>

    @GET("images/search")
    fun searchByBreeds(
        @Query("breed_ids")breed_ids:String,
        @Query("page")page:Int,
        @Query("limit")limit:Int=10
    ):Call<List<CatItem>>


}