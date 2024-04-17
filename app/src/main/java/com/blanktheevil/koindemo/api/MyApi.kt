package com.blanktheevil.koindemo.api

import com.squareup.moshi.JsonClass
import retrofit2.http.GET

interface MyApi {
    @GET("dummy")
    suspend fun getData(): MyData
}

@JsonClass(generateAdapter = true)
data class MyData(val data: String)