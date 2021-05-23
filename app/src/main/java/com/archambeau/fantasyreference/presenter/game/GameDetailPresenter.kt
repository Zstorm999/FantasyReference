package com.archambeau.fantasyreference.presenter.game

import com.archambeau.fantasyreference.R
import com.archambeau.fantasyreference.presenter.Game
import com.archambeau.fantasyreference.presenter.Presenter
import com.archambeau.fantasyreference.views.game.GameDetailFragment
import java.text.SimpleDateFormat
import java.util.*

class GameDetailPresenter(override val fragment: GameDetailFragment) : Presenter(fragment){

    lateinit var game : Game

    override fun init() {
        game  = fragment.arguments?.get("game") as Game

        fragment.nameLabel.text = game.name


        if(game.releasedDate == Date(0))
            fragment.dateLabel.text = fragment.getString(R.string.unknown_release)
        else
            fragment.dateLabel.text = SimpleDateFormat("dd MMMM, yyyy", Locale.UK).format(game.releasedDate)

        fragment.devLabel.text = game.developer
        fragment.publisherLabel.text = game.publisher

        fragment.descriptionLabel.text = game.description

    }
}
