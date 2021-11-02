package com.example.moneytrack.data

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Entity(tableName = "Expendeture")
data class ModelDB (
    @ColumnInfo(name = "Desc")
    var desc:String,
    @ColumnInfo(name = "expendeture")
    var amount:Int
        ){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int?=null
}
