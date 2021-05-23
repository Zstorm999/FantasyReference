package com.archambeau.fantasyreference.views.game


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.archambeau.fantasyreference.R
import com.archambeau.fantasyreference.presenter.game.GameDetailPresenter
import com.archambeau.fantasyreference.views.CustomFragment
import kotlinx.android.synthetic.main.fragment_game_detail.*

class GameDetailFragment : CustomFragment (){
    override val presenter = GameDetailPresenter(this)

    lateinit var nameLabel : TextView
    lateinit var descriptionLabel : TextView
    lateinit var dateLabel : TextView
    lateinit var devLabel : TextView
    lateinit var publisherLabel : TextView
    lateinit var gameImage : ImageView

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backButton : Button  = view.findViewById(R.id.gamedetail_goback_button)

        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_GameDetailFragment_to_GameListFragment)
        }

        nameLabel = view.findViewById(R.id.gamedetail_name_label)
        descriptionLabel = view.findViewById(R.id.gamedetail_description_label)
        dateLabel = view.findViewById(R.id.gamedetail_date_label)
        devLabel = view.findViewById(R.id.gamedetail_developer_label)
        publisherLabel = view.findViewById(R.id.gamedetail_publisher_label)
        gameImage = view.findViewById(R.id.gamedetail_image)

        presenter.init()

    }
}