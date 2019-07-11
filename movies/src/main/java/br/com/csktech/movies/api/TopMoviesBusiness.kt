package br.com.csktech.movies.api

class TopMoviesBusiness {

    fun fetchTopMovies(onSuccess: (MutableList<Movie>) -> Unit, onError: (String) -> Unit) {
        TopMoviesNetworkApi.fetchTopMoviesFromApi({
            it.results?.let { movies ->
                onSuccess(movies)
            }
        }, onError = {
            onError(it)

        })
    }
}