package com.gaziev.androidtest.ui

import androidx.lifecycle.ViewModel
import com.gaziev.androidtest.data.models.MyData
import com.gaziev.androidtest.domain.GetDataUseCase
import com.gaziev.androidtest.domain.InsertDataUseCase

class MainViewModel(
    private val getDataUseCase: GetDataUseCase,
    private val insertDataUseCase: InsertDataUseCase
) : ViewModel() {

    fun getData(): MyData = getDataUseCase.get()

    fun insertData(myData: MyData): Boolean {
        return insertDataUseCase.insert(myData)
    }

}