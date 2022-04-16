package com.gaziev.androidtest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gaziev.androidtest.data.repository.GetDataRepository
import com.gaziev.androidtest.data.repository.InsertDataRepository
import com.gaziev.androidtest.data.repository.Storage
import com.gaziev.androidtest.data.storage.RoomStorage
import com.gaziev.androidtest.domain.GetData
import com.gaziev.androidtest.domain.GetDataUseCase
import com.gaziev.androidtest.domain.InsertData
import com.gaziev.androidtest.domain.InsertDataUseCase

class ViewModelFactory : ViewModelProvider.Factory {

    private val storage: Storage = RoomStorage()

    private val getRepository: GetData = GetDataRepository(storage)
    private val insertRepository: InsertData = InsertDataRepository(storage)

    private val getDataUseCase: GetDataUseCase = GetDataUseCase(getRepository)
    private val insertDataUseCase: InsertDataUseCase = InsertDataUseCase(insertRepository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MainViewModel::class.java) ->
                return MainViewModel(getDataUseCase, insertDataUseCase) as T
        }
        return modelClass.newInstance()
    }
}