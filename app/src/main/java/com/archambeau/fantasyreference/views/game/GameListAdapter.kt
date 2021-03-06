package com.archambeau.fantasyreference.views.game

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.archambeau.fantasyreference.R
import com.archambeau.fantasyreference.presenter.Game

class GameListAdapter (private var dataSet: List<Game>, var listener: ((Game)->Unit)? = null) :
    RecyclerView.Adapter<GameListAdapter.ViewHolder>()
{
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val textView : TextView = view.findViewById(R.id.list_item)
    }

    class ListViewModel : ViewModel() {
        val currentList : MutableLiveData<List<Game>> by lazy{
            MutableLiveData<List<Game>>()
        }
    }


    fun UpdateList(list: List<Game>){
        dataSet = list
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(viewGroup : ViewGroup, viewType : Int) : ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                                 .inflate(R.layout.text_row_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val game = dataSet[position]
        holder.textView.text = game.name


        holder.itemView.setOnClickListener{
            listener?.invoke(game)
        }

    }

    override fun getItemCount() = dataSet.size

}