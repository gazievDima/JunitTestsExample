package com.gaziev.androidtest.data.repository

import com.gaziev.androidtest.data.models.MyData
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetDataRepositoryTest {

    @Mock
    private lateinit var storage: Storage

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun after() {
        Mockito.reset(storage)
    }

    @Test
    fun get_Should_Return_Object_MyData() {
        val myData = MyData("data")
        val getDataRepository = GetDataRepository(storage)
        Mockito.`when`(storage.get()).thenReturn(myData)

        val actual = getDataRepository.get()

        assertEquals(myData, actual)
    }

    @Test
    fun get_Should_Call_Object_Storage_Method_Get_One_Time() {
        val myData = MyData("data")
        val getDataRepository = GetDataRepository(storage)
        Mockito.`when`(storage.get()).thenReturn(myData)

        getDataRepository.get()

        Mockito.verify(storage, Mockito.times(1)).get()
    }
}