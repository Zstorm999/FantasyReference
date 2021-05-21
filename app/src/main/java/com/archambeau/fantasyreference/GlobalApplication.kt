package com.archambeau.fantasyreference

import android.app.Application
import com.archambeau.fantasyreference.model.cache.DBManager


class GlobalApplication : Application() {


    @Override
    override fun onCreate() {
        super.onCreate()

        //start the database
        DBManager.initDataBase(applicationContext)

    }

}