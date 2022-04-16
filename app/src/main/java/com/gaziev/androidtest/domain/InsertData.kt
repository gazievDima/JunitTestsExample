package com.gaziev.androidtest.domain

import com.gaziev.androidtest.data.models.MyData

interface InsertData {
    fun insert(myData: MyData): Boolean
}