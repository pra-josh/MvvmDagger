package com.pra.daggermvvm.di.app

import com.pra.daggermvvm.MainActivity
import dagger.Component

@ApplicationScope
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}