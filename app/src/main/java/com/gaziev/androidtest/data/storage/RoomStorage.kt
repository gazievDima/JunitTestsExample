package com.gaziev.androidtest.data.storage

import com.gaziev.androidtest.data.models.MyData
import com.gaziev.androidtest.data.repository.Storage

class RoomStorage : Storage {

    override fun get(): MyData {
        return MyData("data")
    }

    override fun insert(myData: MyData): Boolean {
        return true
    }
}