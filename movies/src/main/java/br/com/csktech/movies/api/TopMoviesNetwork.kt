package br.com.csktech.movies.api

object TopMoviesNetwork : BaseNetwork() {

    private const val key = "a8b15cb8e4b148e23a32afe20e64cde9"
    private const val lang = "pt-BR"

    private val API by lazy {
        getRetrotif().create(TopMoviesApi::class.java)
    }

    fun getTopMoviesFromApi(onSuccess: (ApiResponse<MutableList<Movie>>) -> Unit, onError: (String) -> Unit) {
        doRequest(API, onSuccess, onError) {
            getTopMovies(
                key,
                lang
            )
        }
    }
}

