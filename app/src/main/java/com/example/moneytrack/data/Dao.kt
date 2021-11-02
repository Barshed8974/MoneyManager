package com.example.moneytrack.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun addMoney(modelDB: ModelDB)

    @Query("select * from Expendeture")
    fun getTable():LiveData<List<ModelDB>>

    @Query("select SUM(expendeture) from Expendeture")
    fun getTotal():LiveData<Int>

    @Update
    fun updateData(modelDB: ModelDB)

    @Delete
    fun deleteData(modelDB: ModelDB)
}
