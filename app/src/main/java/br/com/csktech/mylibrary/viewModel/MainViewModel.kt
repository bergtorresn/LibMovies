package br.com.csktech.mylibrary.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.csktech.movies.api.Movie
import br.com.csktech.movies.api.TopMoviesBusiness

class MainViewModel(private val topMoviesBusiness: TopMoviesBusiness) : ViewModel(){

    var successLiveData = MutableLiveData<MutableList<Movie>>()
    var errorLiveData = MutableLiveData<String>()
    var loadingLiveData = MutableLiveData<Boolean>()

    fun fetchMovies(){
        this.setLoadingVisibility(true)
        this.topMoviesBusiness.fetchTopMovies({movies ->
            this.successLiveData.value = movies
            this.setLoadingVisibility(false)
        }, {error ->
            this.errorLiveData.value = error
            this.setLoadingVisibility(false)
        })
    }

    private fun setLoadingVisibility(visible: Boolean){
        loadingLiveData.postValue(visible)
    }
}