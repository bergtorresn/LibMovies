package br.com.csktech.movies.api

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("vote_cout")
    var vote_cout : Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("video")
    var video : Boolean = false

    @SerializedName("vote_average")
    var vote_average: Float = 0F

    @SerializedName("title")
    var title: String = ""

    @SerializedName("popularity")
    var popularity: Float = 0F

    @SerializedName("poster_path")
    var poster_path: String = ""

    @SerializedName("original_language")
    var original_language: String = ""

    @SerializedName("original_title")
    var original_title: String = ""

    @SerializedName("backdrop_path")
    var backdrop_path: String = ""

    @SerializedName("adult")
    var adult: Boolean = false

    @SerializedName("overview")
    var overview: String = ""

    @SerializedName("release_date")
    var release_date: String = ""

}