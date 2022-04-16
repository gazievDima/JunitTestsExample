package com.gaziev.androidtest.data.repository

import com.gaziev.androidtest.data.models.MyData
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(Parameterized::class)
class InsertDataRepositoryTest(private val resultBoolean: Boolean) {

    @Mock
    private lateinit var storage: Storage

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

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun after() {
        Mockito.reset(storage)
    }

    @Test
    fun insert_Should_Return_True_Or_False() {
        val myData = MyData("data")
        val insertDataRepository = InsertDataRepository(storage)
        Mockito.`when`(storage.insert(myData)).thenReturn(resultBoolean)

        val actual = insertDataRepository.insert(myData)

        assertEquals(resultBoolean, actual)
    }

    @Test
    fun insert_Should_Call_Object_Storage_Method_One_Time() {
        val myData = MyData("data")
        val insertDataRepository = InsertDataRepository(storage)
        Mockito.`when`(storage.insert(myData)).thenReturn(anyBoolean())

        insertDataRepository.insert(myData)

        Mockito.verify(storage, Mockito.times(1)).insert(myData)
    }
}