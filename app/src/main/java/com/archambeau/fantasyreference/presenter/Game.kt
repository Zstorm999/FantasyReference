package com.archambeau.fantasyreference.presenter


import android.util.Log
import com.archambeau.fantasyreference.model.api.APIResponse
import java.io.Serializable
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


data class Game(
    val APIId: String,
    val name: String,
    val description: String,
    val developer: String,
    val publisher: String,
    val _releasedDate: Date,

) : Serializable
{
    var releasedDate: Date = _releasedDate
        private set

    constructor(game: APIResponse.Game) :
            this(game._id,
                 game.name,
                 game.description,
                 game.developer,
                 game.publisher,
                 Date(0)
            )
    {
        val df = SimpleDateFormat(" MMMM d, y", Locale.ENGLISH)

        try{
            releasedDate = df.parse(game.released_date)
        }
        catch (e: Exception){
            //do nothing
            Log.d("Parsing Error", "WTF")
        }

    }

}