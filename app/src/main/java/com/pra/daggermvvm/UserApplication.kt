package com.pra.daggermvvm

import android.app.Application
import com.pra.daggermvvm.di.app.AppComponent
import com.pra.daggermvvm.di.app.DaggerAppComponent

class UserApplication : Application() {

    lateinit var appComponennt: AppComponent

    companion object {
        private var instance: UserApplication? = null
        fun getInstance(): UserApplication {
            if (instance == null) {
                instance = UserApplication()
            }
            return instance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        appComponennt = DaggerAppComponent.builder().build()

    }
}