package br.com.csktech.movies.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.security.auth.callback.Callback

internal open class ApiBaseNetwork {

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    protected fun getRetrotif(): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    protected fun <T, A> doRequest(
        api: A, onSuccess: (response: T) -> Unit, onError: (error: String) -> Unit,
        func: A.() -> Call<T>
    ) {
        api.func().enqueue(object : Callback, retrofit2.Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                onError(t?.localizedMessage)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onSuccess(it)
                    }
                }
            }
        })
    }
}