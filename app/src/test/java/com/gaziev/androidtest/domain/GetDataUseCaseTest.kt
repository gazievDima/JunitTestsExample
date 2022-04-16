package com.gaziev.androidtest.domain

import com.gaziev.androidtest.data.models.MyData
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

class GetDataUseCaseTest {

    @Mock
    private lateinit var getDataRepository: GetData

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun after() {
        Mockito.reset(getDataRepository)
    }

    @Test
    fun get_Should_Return_MyData_Object() {
        val getDataUseCase = GetDataUseCase(getDataRepository)
        Mockito.`when`(getDataRepository.get()).thenReturn(MyData("data"))

        val actual = getDataUseCase.get()
        val expected = MyData("data")

        assertEquals(expected, actual)
    }

    @Test
    fun get_Should_Call_One_Time() {
        val getDataUseCase = GetDataUseCase(getDataRepository)
        Mockito.`when`(getDataRepository.get()).thenReturn(MyData("data"))

        getDataUseCase.get()
        Mockito.verify(getDataRepository, Mockito.times(1)).get()
    }

}