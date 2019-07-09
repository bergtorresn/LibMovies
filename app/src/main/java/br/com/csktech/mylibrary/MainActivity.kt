package br.com.csktech.mylibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import br.com.csktech.movies.api.TopMoviesBusiness
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TopMoviesBusiness.getTopMovies(onSuccess = {
            tv_home.text = it.first().title
        }, onError = {
            Log.e("TOP_MOVIES_ERROR", it)
        })
    }
}
