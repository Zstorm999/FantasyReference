package com.archambeau.fantasyreference.presenter

import com.archambeau.fantasyreference.views.CustomFragment

abstract class Presenter(protected open val fragment: CustomFragment) {

    abstract fun init()

}