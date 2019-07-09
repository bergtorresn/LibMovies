package br.com.csktech.movies.api

class ApiResponse<T> {

    var page: Int? = null
    var total_results: Int? = null
    var total_pages: Int? = null
    var results: T? = null

}