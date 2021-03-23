package com.archambeau.fantasyreference.views.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archambeau.fantasyreference.R

class BookListFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private val adapter = CustomAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.booklist_recyclerview)

        recyclerView.apply {
            layoutManager = this@BookListFragment.layoutManager
            adapter = this@BookListFragment.adapter
        }

        val booksList = arrayListOf<String>().apply {
            add("The community of the ring")
            add("The two towers")
            add("The return of the king")
        }

        adapter.UpdateList(booksList)
    }

}