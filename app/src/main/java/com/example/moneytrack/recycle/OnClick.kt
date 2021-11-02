package com.example.moneytrack.recycle

import com.example.moneytrack.data.ModelDB

interface OnClick {
    fun edit(modelDB: ModelDB)

    fun delete(modelDB: ModelDB)
}