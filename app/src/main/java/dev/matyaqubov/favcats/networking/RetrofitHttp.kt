package dev.matyaqubov.favcats.networking

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHttp {
    val IS_TESTER=true
    var SERVER_DEVELOPMENT = "https://api.thecatapi.com/v1/"
    var SERVER_PRODUCTION = "https://api.thecatapi.com/v1/"

    private val client= getClient()
    private val retrofit = getRetrofit(client)

    fun getRetrofit(client: OkHttpClient): Retrofit {
        val build = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(server())
            .client(client)
            .build()
        return build
    }


    fun getClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(Interceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.header("x-api-key", "f0e25583-dde6-4368-91be-6cffc7c33576")
            chain.proceed(builder.build())
        })
        .build()

    private fun server(): String {
        if (IS_TESTER)
            return SERVER_DEVELOPMENT
        return SERVER_PRODUCTION
    }



    val apiService: ApiService = retrofit.create(ApiService::class.java)
}