package br.com.csktech.movies.api

import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopMoviesNetworkApi : ApiBaseNetwork() {

    private val key = "a8b15cb8e4b148e23a32afe20e64cde9"
    private val lang = "pt-BR"

    private val API by lazy {
        getRetrotif().create(TopMoviesApi::class.java)
    }

    fun fetchTopMoviesFromApi(onSuccess: (ApiResponse) -> Unit, onError: (String) -> Unit) {
        /* doRequest(API, onSuccess, onError) {
             fetchTopMovies(key, lang)
         } */

        API.fetchTopMovies(key, lang).enqueue(object : Callback<ApiResponse> {

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                onError(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {

                try {
                    when (response.code()) {
                        200 -> {
                            if (response.isSuccessful) {
                                response.body()?.let {
                                    onSuccess(it)
                                } ?: run {
                                    onError("*** ERRO body null ")
                                }
                            } else {
                                onError("*** ERRO response isntSuccessful")
                            }
                        }
                        else -> {
                            onError("*** Code ${response.code()}")
                        }
                    }
                } catch (e: Exception) {
                    onError("*** ERRO NO RESPONSE ${e.localizedMessage}")
                }
            }
        })
    }
}
