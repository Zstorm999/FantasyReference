package com.archambeau.fantasyreference.views.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.archambeau.fantasyreference.R

class CustomAdapter (private var dataSet: List<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>()
{

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val textView : TextView

        init {
            //Need to set a valid view for this
            textView = view.findViewById(R.id.list_item)
        }
    }

    fun UpdateList(list: List<String>){
        dataSet = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup : ViewGroup, viewType : Int) : ViewHolder{
        val view = LayoutInflater.from(viewGroup.context)
                                 .inflate(R.layout.text_row_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size

}