package com.pra.daggermvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pra.daggermvvm.model.Products

@Database(entities = [Products::class], version = 1)
abstract class AppDb:RoomDatabase() {

    abstract fun productDao():ProductDao

}