package com.pra.daggermvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pra.daggermvvm.model.Products

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun saveProducts(userList: List<Products>)

    @Query("SELECT * FROM Products")
     fun getAllUser(): List<Products>

    @Query("DELETE from Products")
     fun deleteAllUser()
}