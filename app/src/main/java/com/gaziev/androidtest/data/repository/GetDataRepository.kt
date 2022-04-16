package com.gaziev.androidtest.data.repository

import com.gaziev.androidtest.data.models.MyData
import com.gaziev.androidtest.domain.GetData

class GetDataRepository(
    private val storage: Storage
) : GetData {

    override fun get(): MyData {
        return storage.get()
    }
}