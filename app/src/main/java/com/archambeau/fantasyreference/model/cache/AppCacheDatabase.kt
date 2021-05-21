package com.archambeau.fantasyreference.model.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = arrayOf(DBEntities.Game::class), version = 1)
@TypeConverters(Converters::class)
abstract class AppCacheDatabase : RoomDatabase(){

    abstract fun gameDao(): GameDAO

}