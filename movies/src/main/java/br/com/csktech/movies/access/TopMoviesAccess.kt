package br.com.csktech.movies.access

import br.com.csktech.movies.api.TopMoviesNetwork
import br.com.csktech.movies.model.Movie

class TopMoviesAccess {

    fun fetchTopMovies(onSuccess: (MutableList<Movie>) -> Unit, onError: (String) -> Unit) {
        TopMoviesNetwork().fetchTopMoviesFromApi({ response ->
            response.results?.let { movies ->
                onSuccess(movies)
            }
        }, onError = {
            onError("*** ERRO - $it")
        })
    }
}