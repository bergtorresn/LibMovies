package br.com.csktech.movies.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TopMoviesApi {

    @GET("movie/popular")
    fun getTopMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ): Observable<ApiResponse<MutableList<Movie>>>
}