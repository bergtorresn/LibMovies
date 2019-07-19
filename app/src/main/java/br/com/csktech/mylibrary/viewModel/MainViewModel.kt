package br.com.csktech.mylibrary.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.csktech.movies.model.Movie
import br.com.csktech.movies.access.TopMoviesAccess

class MainViewModel(private val topMoviesAccess: TopMoviesAccess) : ViewModel(){

    var successLiveData = MutableLiveData<MutableList<Movie>>()
    var errorLiveData = MutableLiveData<String>()
    var loadingLiveData = MutableLiveData<Boolean>()

    fun fetchMovies(){
        this.setLoadingVisibility(true)
        this.topMoviesAccess.fetchTopMovies({ movies ->
            this.successLiveData.postValue(movies)
            this.setLoadingVisibility(false)
        }, {error ->
            this.errorLiveData.postValue(error)
            this.setLoadingVisibility(false)
        })
    }

    private fun setLoadingVisibility(visible: Boolean){
        loadingLiveData.postValue(visible)
    }
}