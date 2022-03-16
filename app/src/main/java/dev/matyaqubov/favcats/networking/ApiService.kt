package dev.matyaqubov.favcats.networking

import dev.matyaqubov.favcats.networking.model.BreedItem
import dev.matyaqubov.favcats.networking.model.CatItem
import dev.matyaqubov.favcats.networking.model.Upload
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.*
import java.io.File
import retrofit2.http.POST

import retrofit2.http.Multipart




interface ApiService {

    @GET("breeds")
    fun getAllBreeds(): Call<ArrayList<BreedItem>>

    @GET("images/search")
    fun searchByBreeds(
        @Query("breed_ids") breed_ids: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int = 10
    ): Call<List<CatItem>>


//    @Multipart
//    @POST("images/upload")
//    fun uploadImage(
//        @Part file:MultipartBody.Part,
//        @Part sub_id: RequestBody,
//    ):Call<ResponseBody>

//    @Multipart
//    @POST("images/upload")
//    fun uploadImage(
//        @Part("file") file: MultipartBody.Part,
//        @Part("sub_id") sub_id: RequestBody
//    ): Call<ResponseBody>


    @Multipart
    @POST("images/upload")
    fun uploadFile(@Part image: MultipartBody.Part, @Part("file") name: RequestBody): Call<Upload>

    @GET("images")
    fun getMyImages(
        @Query("page")page:Int,
        @Query("limit")limit:Int=20,
    ):Call<List<Upload>>
}