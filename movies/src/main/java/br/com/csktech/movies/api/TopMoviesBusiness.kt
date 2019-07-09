package br.com.csktech.movies.api

object TopMoviesBusiness {

    fun getTopMovies(onSuccess: (MutableList<Movie>) -> Unit, onError: (String) -> Unit) {
        TopMoviesNetwork.getTopMoviesFromApi(onSuccess = {
            it.results?.let { movies ->
                onSuccess(movies)
            }
        }, onError = { error ->
            onError(error)
        })
    }
}