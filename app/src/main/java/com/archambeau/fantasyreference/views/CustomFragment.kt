package com.archambeau.fantasyreference.views


import androidx.fragment.app.Fragment
import com.archambeau.fantasyreference.presenter.Presenter

abstract class CustomFragment() : Fragment (){

    abstract val presenter: Presenter
}