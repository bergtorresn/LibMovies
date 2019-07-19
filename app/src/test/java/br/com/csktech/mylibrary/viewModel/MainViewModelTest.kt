package br.com.csktech.mylibrary.viewModel

import br.com.csktech.movies.access.TopMoviesAccess
import org.junit.After
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class MainViewModelTest {

    @Mock
    lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.mainViewModel = MainViewModel(TopMoviesAccess())
    }

    @Test
    fun testFetchMovies(){

       // this.mainViewModel.successLiveData.observeForever { mock(Observer::class.java) as Observer<MutableList<Movie>> }
        this.mainViewModel.fetchMovies()

        assertNull(this.mainViewModel.successLiveData.value)
    }


    @After
    fun tearDown() {
    }
}