package com.archambeau.fantasyreference.views.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archambeau.fantasyreference.R
import com.archambeau.fantasyreference.data.Game
import com.archambeau.fantasyreference.presenter.game.GameListPresenter
import com.archambeau.fantasyreference.views.CustomFragment

class GameListFragment() : CustomFragment() {

    override val presenter = GameListPresenter(this)

    private lateinit var recyclerView : RecyclerView

    val adapter = GameListAdapter(listOf(), ::onItemClicked)

    private val layoutManager = LinearLayoutManager(context)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.booklist_recyclerview)

        recyclerView.apply {
            layoutManager = this@GameListFragment.layoutManager
            adapter = this@GameListFragment.adapter
        }

        presenter.init()

    }

    //TODO: move this to presenter
    private fun onItemClicked(game: Game) {
        findNavController().navigate(R.id.action_GameListFragment_to_GameDetailFragment)
    }



}