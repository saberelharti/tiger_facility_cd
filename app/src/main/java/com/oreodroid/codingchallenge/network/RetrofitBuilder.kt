package com.oreodroid.codingchallenge.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL: String = "http://private-14c693-rentapanda.apiary-mock.com/"

    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService: ApiService by lazy {

        retrofitBuilder
            .build()
            .create(ApiService::class.java)
    }
}