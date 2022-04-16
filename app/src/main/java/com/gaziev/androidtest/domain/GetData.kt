package com.gaziev.androidtest.domain

import com.gaziev.androidtest.data.models.MyData

interface GetData {
    fun get(): MyData
}