package br.com.csktech.movies.api

import br.com.csktech.movies.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TopMoviesApi {

    @GET("movie/popular")
    fun fetchTopMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Call<ApiResponse<MutableList<Movie>>>
}