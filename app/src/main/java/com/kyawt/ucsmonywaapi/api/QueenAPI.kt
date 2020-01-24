package com.kyawt.ucsmonywaapi.api

import com.kyawt.ucsmonywaapi.Queen
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QueenAPI{
    @GET("queen")
    fun getQueen():Call<List<Queen>>
}