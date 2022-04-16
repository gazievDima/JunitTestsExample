package com.gaziev.androidtest.data.repository

import com.gaziev.androidtest.data.models.MyData

interface Storage {
    fun get(): MyData
    fun insert(myData: MyData): Boolean
}