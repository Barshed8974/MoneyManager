package com.example.moneytrack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moneytrack.data.ModelDB
import com.example.moneytrack.repo.MyRepository

class MyViewModel(val repository: MyRepository):ViewModel() {

    fun getTable():LiveData<List<ModelDB>>
    {
        return repository.getTable()
    }

    fun createData(modelDB: ModelDB)
    {
        repository.addMoney(modelDB)
    }

    fun updateData(modelDB: ModelDB)
    {
        repository.editTable(modelDB)
    }

    fun deleteData(modelDB: ModelDB)
    {
        repository.deleteTable(modelDB)
    }

    fun getTotal():LiveData<Int>
    {
        return repository.getTotal()
    }
}
