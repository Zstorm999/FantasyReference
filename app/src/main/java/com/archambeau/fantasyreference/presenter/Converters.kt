package com.archambeau.fantasyreference.presenter

import com.archambeau.fantasyreference.model.cache.DBEntities
import java.util.*

object Converters {

    fun game_PresenterToDB(game : Game): DBEntities.Game {

        return DBEntities.Game(
            game.APIId,
            game.name,
            game.description,
            game.developer,
            game.publisher,
            game.releasedDate,
            Date())
    }

    fun game_DBToPresenter(game : DBEntities.Game): Game {

        return Game(
            game.id,
            game.name,
            game.description,
            game.developer,
            game.publisher,
            game.releasedDate)
    }

}