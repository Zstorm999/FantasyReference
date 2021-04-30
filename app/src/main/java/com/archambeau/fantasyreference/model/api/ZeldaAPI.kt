package com.archambeau.fantasyreference.model.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ZeldaAPI {
    @GET("games")
    fun getGameList(@Query("limit") limit: Int)
                    : Call<GamesResponse>

    @GET("staff")
    fun getStaffList()
                    : Call<GamesResponse>

}

