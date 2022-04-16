package com.gaziev.androidtest.domain

import com.gaziev.androidtest.data.models.MyData

class GetDataUseCase(
    private val getDataRepository: GetData,
) {

    fun get(): MyData = getDataRepository.get()
}