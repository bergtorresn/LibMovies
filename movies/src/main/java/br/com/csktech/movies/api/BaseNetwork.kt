package br.com.csktech.movies.api

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class BaseNetwork {

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

        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient).build()
    }

    protected fun <T, A> doRequest(
        api: A,
        onSuccess: (response: T) -> Unit,
        onError: (error: String) -> Unit,
        func: A.() -> Observable<T>
    ): Disposable {
        return api.func()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                onSuccess(response)
            }, {
                try {
                    val response = (it as HttpException).response().errorBody()
                    val jSon = JSONObject(response!!.string())
                    onError(jSon.getString("message"))
                } catch (e: Exception) {
                    onError("Tente novamente")
                }
            })
    }
}