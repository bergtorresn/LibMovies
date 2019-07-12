package br.com.csktech.movies.api

import android.util.Log

class TopMoviesBusiness {

    fun fetchTopMovies(onSuccess: (MutableList<Movie>) -> Unit, onError: (String) -> Unit) {
        TopMoviesNetworkApi().fetchTopMoviesFromApi({

            Log.i("***", "${it.page}")
            Log.i("***", "${it.results?.size}")

            it.results?.let { movies ->
                onSuccess(movies)
            } ?: run {
                onError("*** ERRO - Não foi possível realizar o parse do json")
            }
        }, onError = {
            onError("*** ERRO - $it")
        })
    }
}