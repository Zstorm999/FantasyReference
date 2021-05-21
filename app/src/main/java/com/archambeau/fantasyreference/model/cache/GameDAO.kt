package com.archambeau.fantasyreference.model.cache

import androidx.room.*

@Dao
interface GameDAO {

    @Insert
    fun insertAll(vararg games: DBEntities.Game)

    @Update
    fun updateGames(vararg games: DBEntities.Game)

    @Delete
    fun delete(game : DBEntities.Game) : Int

    @Query("SELECT * FROM games")
    fun getAll(): List<DBEntities.Game>

    @Query("SELECT * FROM games WHERE id = :id")
    fun getID(id: String):  DBEntities.Game

}