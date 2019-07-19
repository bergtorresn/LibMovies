package br.com.csktech.mylibrary.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.csktech.movies.access.TopMoviesAccess
import br.com.csktech.mylibrary.R
import br.com.csktech.mylibrary.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainViewModel(TopMoviesAccess())
        viewModel.fetchMovies()

        setupUI(viewModel)
    }

    private fun setupUI(viewModel: MainViewModel) {

        with(viewModel) {
            loadingLiveData.observe(this@MainActivity, Observer {
                it?.let { visible ->
                    if (visible) {
                        pbHome.visibility = View.VISIBLE
                    } else {
                        pbHome.visibility = View.GONE
                    }
                }
            })

            successLiveData.observe(this@MainActivity, Observer { movies ->
                movies?.let {
                    tvHome.text = it.first().title
                }
            })

            errorLiveData.observe(this@MainActivity, Observer { error ->
                error?.let {
                    tvHome.text = it
                }
            })
        }
    }
}
