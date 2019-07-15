package br.com.csktech.movies.api

import com.google.gson.annotations.SerializedName

class ApiResponse {

    @SerializedName("page")
    var page: Int? = null

    @SerializedName("total_results")
    var total_results: Int? = null

    @SerializedName("total_pages")
    var total_pages: Int? = null

    @SerializedName("results")
    var results: MutableList<Movie>? = null

}