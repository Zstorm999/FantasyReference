package com.archambeau.fantasyreference.presenter.game

import com.archambeau.fantasyreference.presenter.Game
import com.archambeau.fantasyreference.model.api.APIConnection
import com.archambeau.fantasyreference.model.api.APIResponse
import com.archambeau.fantasyreference.presenter.Presenter
import com.archambeau.fantasyreference.views.game.GameListFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameListPresenter(override val fragment: GameListFragment) : Presenter(fragment){

    override fun init() {

        //TODO: connect to general database manager (or be database manager)
        APIConnection.zeldaAPI.getGameList(20).enqueue(object : Callback<APIResponse.GameList> {
            override fun onFailure(call: Call<APIResponse.GameList>, t: Throwable) {
                //TODO: Not yet implemented
            }

            override fun onResponse(call: Call<APIResponse.GameList>, response: Response<APIResponse.GameList>) {
                if(response.isSuccessful){
                    val gamesResponse = response.body()

                    val games = List<Game>(gamesResponse!!.count) {

                        //gamesResponse.data[it].released_date = "February 21, 1986"
                        return@List Game(gamesResponse.data[it])
                    }

                    fragment.adapter.UpdateList(games)
                }
            }
        })


    }


}