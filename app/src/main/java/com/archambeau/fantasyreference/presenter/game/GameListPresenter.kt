package com.archambeau.fantasyreference.presenter.game

import android.os.AsyncTask
import android.widget.ProgressBar
import androidx.core.view.isInvisible
import com.archambeau.fantasyreference.R
import com.archambeau.fantasyreference.presenter.Game
import com.archambeau.fantasyreference.model.api.APIConnection
import com.archambeau.fantasyreference.model.api.APIResponse
import com.archambeau.fantasyreference.model.cache.DBManager
import com.archambeau.fantasyreference.presenter.Converters
import com.archambeau.fantasyreference.presenter.Presenter
import com.archambeau.fantasyreference.views.game.GameListFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameListPresenter(override val fragment: GameListFragment) : Presenter(fragment){


    //TODO: switch to a not depreciated way of doing things
    private inner class LoadDBFilesTask : AsyncTask<Unit, Unit, List<Game>>() {

        override fun doInBackground(vararg params: Unit?): List<Game> {
            val dbGames = DBManager.games.getAll()

            return List(dbGames.size) {
                return@List Converters.game_DBToPresenter(dbGames[it])
            }

        }

        override fun onPostExecute(games : List<Game>){
            this@GameListPresenter.fragment.adapter.UpdateList(games)
        }

    }


    override fun init() {

        //first we load what we have in the database

        LoadDBFilesTask().execute()

        //then we load from the network, overwriting the database stuff

        //TODO: connect to general database manager (or be database manager)
        APIConnection.zeldaAPI.getGameList(30).enqueue(object : Callback<APIResponse.GameList> {
            override fun onFailure(call: Call<APIResponse.GameList>, t: Throwable) {
                loadFailure()
            }

            override fun onResponse(call: Call<APIResponse.GameList>, response: Response<APIResponse.GameList>) {
                if(response.isSuccessful){
                    val gamesResponse = response.body()

                    val games = List<Game>(gamesResponse!!.count) {

                        //gamesResponse.data[it].released_date = "February 21, 1986"
                        return@List Game(gamesResponse.data[it])
                    }

                    Thread{
                        games.forEach {

                            if(DBManager.games.countWithID(it.APIId) == 0){

                                    DBManager.games.insertAll(Converters.game_PresenterToDB(it))
                            }
                        }
                    }.start()

                    fragment.adapter.UpdateList(games)

                    loadSuccessfull()
                }
            }
        })
    }

    fun loadFailure(){
        val loadingBar : ProgressBar? = fragment.view?.findViewById(R.id.progressBar)

        loadingBar?.isInvisible = true
        loadingBar?.isEnabled = false
    }

    fun loadSuccessfull(){

        val loadingBar : ProgressBar? = fragment.view?.findViewById(R.id.progressBar)

        loadingBar?.isInvisible = true
        loadingBar?.isEnabled = false
    }



}