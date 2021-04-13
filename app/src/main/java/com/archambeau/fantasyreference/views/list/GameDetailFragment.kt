package com.archambeau.fantasyreference.views.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.archambeau.fantasyreference.R

class GameDetailFragment : Fragment(){

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
    }
}