package com.example.moneytrack.repo

import androidx.lifecycle.LiveData
import com.example.moneytrack.data.Dao
import com.example.moneytrack.data.ModelDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepository (val dao: Dao){
    fun addMoney(modelDB: ModelDB)
    {
        CoroutineScope(Dispatchers.IO).launch {
            dao.addMoney(modelDB)
        }
    }

    fun getTable():LiveData<List<ModelDB>>
    {
        return dao.getTable()
    }

    fun editTable(modelDB: ModelDB)
    {
        CoroutineScope(Dispatchers.IO).launch {
            dao.updateData(modelDB)
        }
    }

    fun deleteTable(modelDB: ModelDB)
    {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteData(modelDB)
        }
    }

    fun getTotal():LiveData<Int>
    {
        return dao.getTotal()
    }
}
