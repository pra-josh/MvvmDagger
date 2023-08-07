package com.pra.daggermvvm.di.app

import android.content.Context
import com.pra.daggermvvm.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [NetworkModule::class,DbModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)

     @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):AppComponent
    }
}