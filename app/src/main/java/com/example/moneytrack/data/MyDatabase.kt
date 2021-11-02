package com.example.moneytrack.data

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.*


@Database(entities = [ModelDB::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun getDatabaseDao():Dao
    companion object{
        private var INSTANCE:MyDatabase?=null
        fun getDatabaseObject(context: Context):MyDatabase
        {
            if (INSTANCE==null)
            {
                val builder=Room.databaseBuilder(context.applicationContext,
                MyDatabase::class.java,"My_DB")
                builder.fallbackToDestructiveMigration()

                INSTANCE=builder.build()
                return INSTANCE!!
            }
            else
                return INSTANCE!!
        }
    }
}
