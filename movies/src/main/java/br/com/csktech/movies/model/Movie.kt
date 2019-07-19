package br.com.csktech.movies.model

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("vote_cout")
    var voteCout : Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("video")
    var video : Boolean = false

    @SerializedName("vote_average")
    var voteAverage: Float = 0F

    @SerializedName("title")
    var title: String = ""

    @SerializedName("popularity")
    var popularity: Float = 0F

    @SerializedName("poster_path")
    var posterPath: String = ""

    @SerializedName("original_language")
    var originalLanguage: String = ""

    @SerializedName("original_title")
    var originalTitle: String = ""

    @SerializedName("backdrop_path")
    var backdropPath: String = ""

    @SerializedName("adult")
    var adult: Boolean = false

    @SerializedName("overview")
    var overview: String = ""

    @SerializedName("release_date")
    var releaseDate: String = ""

}