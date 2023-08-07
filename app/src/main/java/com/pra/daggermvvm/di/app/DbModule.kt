package com.pra.daggermvvm.di.app

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pra.daggermvvm.db.AppDb
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @ApplicationScope
    @Provides
    fun provideAppDb(context: Context):AppDb{
        return Room.databaseBuilder(context, AppDb::class.java, "AppDb.db").allowMainThreadQueries()
           /* .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)*/.build()
    }


}