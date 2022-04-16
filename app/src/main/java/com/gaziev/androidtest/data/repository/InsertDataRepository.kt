package com.gaziev.androidtest.data.repository

import com.gaziev.androidtest.data.models.MyData
import com.gaziev.androidtest.domain.InsertData

class InsertDataRepository(
    private val storage: Storage
) : InsertData {

    override fun insert(myData: MyData): Boolean {
        return storage.insert(myData)
    }
}