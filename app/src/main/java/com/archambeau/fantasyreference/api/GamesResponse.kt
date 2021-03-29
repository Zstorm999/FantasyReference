package com.archambeau.fantasyreference.api

import com.archambeau.fantasyreference.views.list.Game

data class GamesResponse(
    val success : Boolean,
    val count : Int,
    val data : List<Game>
)