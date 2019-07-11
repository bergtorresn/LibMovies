package br.com.csktech.movies.api

internal object TopMoviesNetworkApi : ApiBaseNetwork() {

    private const val key = "a8b15cb8e4b148e23a32afe20e64cde9"
    private const val lang = "pt-BR"

    private val API by lazy {
        getRetrotif().create(TopMoviesApi::class.java)
    }

    fun fetchTopMoviesFromApi(onSuccess: (ApiResponse<MutableList<Movie>>) -> Unit, onError: (String) -> Unit) {
        doRequest(API, onSuccess, onError) {
            fetchTopMovies(key, lang)
        }
    }
}
