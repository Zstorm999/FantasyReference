package com.archambeau.fantasyreference.presenter.game

import com.archambeau.fantasyreference.model.api.APIConnection
import com.archambeau.fantasyreference.model.api.GamesResponse
import com.archambeau.fantasyreference.presenter.Presenter
import com.archambeau.fantasyreference.views.game.GameListFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameListPresenter(override val fragment: GameListFragment) : Presenter(fragment){

    override fun init() {

        //TODO: connect to general database manager (or be database manager)
        APIConnection.zeldaAPI.getGameList(20).enqueue(object : Callback<GamesResponse> {
            override fun onFailure(call: Call<GamesResponse>, t: Throwable) {
                //TODO: Not yet implemented
            }

            override fun onResponse(call: Call<GamesResponse>, response: Response<GamesResponse>) {
                if(response.isSuccessful){
                    val gamesResponse = response.body()

                    fragment.adapter.UpdateList(gamesResponse!!.data)
                }
            }
        })


    }


}