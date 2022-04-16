package com.gaziev.androidtest.domain

import com.gaziev.androidtest.data.models.MyData
import com.gaziev.androidtest.data.repository.InsertDataRepository

class InsertDataUseCase(
    private val insertDataRepository: InsertData
) {

    fun insert(myData: MyData): Boolean {
        val result = insertDataRepository.insert(myData)
        if(result) {
            return true
        } else {
            return false
        }
    }
}