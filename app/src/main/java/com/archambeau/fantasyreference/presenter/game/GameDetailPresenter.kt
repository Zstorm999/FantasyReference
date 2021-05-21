package com.archambeau.fantasyreference.presenter.game

import com.archambeau.fantasyreference.presenter.Game
import com.archambeau.fantasyreference.presenter.Presenter
import com.archambeau.fantasyreference.views.game.GameDetailFragment
import java.text.DateFormat
import java.text.SimpleDateFormat

class GameDetailPresenter(override val fragment: GameDetailFragment) : Presenter(fragment){

    lateinit var game : Game

    override fun init() {
        game  = fragment.arguments?.get("game") as Game

        fragment.nameLabel.text = game.name
        fragment.descriptionLabel.text = game.description
        fragment.dateLabel.text = SimpleDateFormat("dd mm, yyyy").format(game.releasedDate)
    }
}
