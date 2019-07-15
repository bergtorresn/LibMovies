package br.com.csktech.movies.api

import android.util.Log

class TopMoviesBusiness {

    fun fetchTopMovies(onSuccess: (MutableList<Movie>) -> Unit, onError: (String) -> Unit) {
        TopMoviesNetworkApi().fetchTopMoviesFromApi({

            Log.i("*** PAGE", "${it.page}")

           // it.results.let { movies ->
                onSuccess(it.results!!)
           // } ?: run {
         //       onError("*** ERRO - Não foi possível realizar o parse do json")
          //  }
        }, onError = {
            onError("*** ERRO fetchTopMovies - $it")
        })
    }
}