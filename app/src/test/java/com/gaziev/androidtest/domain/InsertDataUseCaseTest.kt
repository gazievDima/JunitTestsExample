package com.gaziev.androidtest.domain

import com.gaziev.androidtest.data.models.MyData
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(Parameterized::class)
class InsertDataUseCaseTest(private val resultBoolean: Boolean) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun booleanParameterized() : Collection<Array<Any>> {
            return listOf(
                arrayOf(true),
                arrayOf(false)
            )
        }
    }

    @Mock
    private lateinit var insertDataRepository: InsertData

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun after() {
        Mockito.reset(insertDataRepository)
    }

    @Test
    fun insert_Should_Return_True_Or_False() {
        val myData = MyData("data")
        val insertDataUseCase = InsertDataUseCase(insertDataRepository)
        Mockito.`when`(insertDataRepository.insert(myData)).thenReturn(resultBoolean)


        val actual = insertDataUseCase.insert(myData)

        assertEquals(resultBoolean, actual)
    }

    @Test
    fun insert_Should_Call_One_Time() {
        val myData = MyData("data")
        val insertDataUseCase = InsertDataUseCase(insertDataRepository)
        Mockito.`when`(insertDataRepository.insert(myData)).thenReturn(true)

        insertDataUseCase.insert(myData)
        Mockito.verify(insertDataRepository, Mockito.times(1)).insert(myData)
    }

}