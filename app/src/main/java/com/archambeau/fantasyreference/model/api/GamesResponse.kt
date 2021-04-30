package com.archambeau.fantasyreference.model.api

import com.archambeau.fantasyreference.data.Game

data class GamesResponse(
    val success : Boolean,
    val count : Int,
    val data : List<Game>
)