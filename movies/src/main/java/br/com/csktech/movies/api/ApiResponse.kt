package br.com.csktech.movies.api

class ApiResponse {

    var page: Int? = null
    var total_results: Int? = null
    var total_pages: Int? = null
    var results: MutableList<Movie>? = null

}