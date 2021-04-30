package com.archambeau.fantasyreference.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIConnection {

    companion object {
        val zeldaAPI : ZeldaAPI = Retrofit.Builder()
            .baseUrl("https://zelda-api.apius.cc/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ZeldaAPI::class.java)
    }
}