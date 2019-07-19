package br.com.csktech.movies.api

import com.google.gson.annotations.SerializedName

class ApiResponse<T>  {

    @SerializedName("page")
    var page: Int? = null

    @SerializedName("total_results")
    var totalResults: Int? = null

    @SerializedName("total_pages")
    var totalPages: Int? = null

    @SerializedName("results")
    var results: T? = null

}