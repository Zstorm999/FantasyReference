package com.archambeau.fantasyreference.model.cache

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object DBManager {

    private lateinit var db : AppCacheDatabase


    lateinit var games : GameDAO
        private set

    fun initDataBase(appContext : Context){
        db = Room.databaseBuilder(
            appContext,
            AppCacheDatabase::class.java, "cache").build()

        games = db.gameDao()

    }

}