package com.gaziev.androidtest.ui

import com.gaziev.androidtest.data.models.MyData
import com.gaziev.androidtest.domain.GetDataUseCase
import com.gaziev.androidtest.domain.InsertDataUseCase
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
class MainViewModelTest(private val resultBoolean: Boolean) {

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
    private lateinit var getDataUseCase: GetDataUseCase

    @Mock
    private lateinit var insertDataUseCase: InsertDataUseCase

    @Before
    fun before() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun after() {
        Mockito.reset(getDataUseCase)
        Mockito.reset(insertDataUseCase)
    }

    @Test
    fun getData_Should_Return_Object_MyData() {
        val myData = MyData("data")
        val viewModel = MainViewModel(getDataUseCase, insertDataUseCase)
        Mockito.`when`(getDataUseCase.get()).thenReturn(myData)

        val actual = viewModel.getData()

        assertEquals(myData, actual)
    }

    @Test
    fun getData_Should_Call_One_Time() {
        val myData = MyData("data")
        val viewModel = MainViewModel(getDataUseCase, insertDataUseCase)
        Mockito.`when`(getDataUseCase.get()).thenReturn(myData)

        viewModel.getData()

        Mockito.verify(getDataUseCase, Mockito.times(1)).get()
    }

    @Test
    fun insertData_Should_Return_Result_Insert_MyData_True_Or_False() {
        val myData = MyData("data")
        val viewModel = MainViewModel(getDataUseCase, insertDataUseCase)
        Mockito.`when`(insertDataUseCase.insert(myData)).thenReturn(resultBoolean)

        val actual = viewModel.insertData(myData)

        assertEquals(resultBoolean, actual)
    }

    @Test
    fun insertData_Should_Call_One_Time() {
        val myData = MyData("data")
        val viewModel = MainViewModel(getDataUseCase, insertDataUseCase)
        Mockito.`when`(insertDataUseCase.insert(myData)).thenReturn(true)

        viewModel.insertData(myData)

        Mockito.verify(insertDataUseCase, Mockito.times(1)).insert(myData)
    }
}