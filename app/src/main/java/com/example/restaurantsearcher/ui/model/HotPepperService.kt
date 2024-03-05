package com.example.restaurantsearcher.ui.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HotPepperService {
    @GET("gourmet/v1/")
    fun getData(
        @Query("key") key: String,
        @Query("keyword") keyword: String,
        @Query("lat") lat: Double,
        @Query("lng") lng: Double,
        @Query("range") range: Int,
        @Query("format") format: String,
    ): Call<HotPepperResponse>
}