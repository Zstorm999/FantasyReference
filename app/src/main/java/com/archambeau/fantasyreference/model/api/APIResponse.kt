package com.archambeau.fantasyreference.model.api


interface APIResponse {
    data class GameList(
        val success : Boolean,
        val count : Int,
        val data : List<Game>
    )

    data class Game(
        var _id : String,
        val name : String,
        val description : String,
        val developer : String,
        val publisher : String,
        var released_date : String
    )
}
