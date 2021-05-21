package com.archambeau.fantasyreference.model.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

interface DBEntities {

    @Entity(tableName = "games")
    data class Game(
        @PrimaryKey val id : String,

        val name : String,
        val description : String,
        val developer : String,
        val publisher : String,

        @ColumnInfo(name="release_date") val releasedDate : Date,
        @ColumnInfo(name="last_updated_date") val lastUpdatedDate : Date
        )

}