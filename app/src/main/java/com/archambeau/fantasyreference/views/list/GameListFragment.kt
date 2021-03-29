package com.archambeau.fantasyreference.views.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archambeau.fantasyreference.R
import com.archambeau.fantasyreference.api.GamesResponse
import com.archambeau.fantasyreference.api.ZeldaAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameListFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private val adapter = CustomAdapter(listOf())
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



        val retrofit = Retrofit.Builder()
            .baseUrl("https://zelda-api.apius.cc/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val zeldaAPI : ZeldaAPI = retrofit.create(ZeldaAPI::class.java)

        zeldaAPI.getGameList(20).enqueue(object : Callback<GamesResponse>{

            override fun onFailure(call: Call<GamesResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<GamesResponse>, response: Response<GamesResponse>) {
                if(response.isSuccessful){
                    val gamesResponse = response.body()

                    adapter.UpdateList(gamesResponse!!.data)

                }
            }

        })
    }

    private fun onItemClicked(game: Game) {

    }

}