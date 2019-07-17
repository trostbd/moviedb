package com.example.moviedbassignment.view

import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.moviedbassignment.R
import com.example.moviedbassignment.adapters.MovieRecyclerAdapter
import com.example.moviedbassignment.databinding.ActivityMainBinding
import com.example.moviedbassignment.component.DaggerAppComponent
import com.example.moviedbassignment.helpers.BASE_URL
import com.example.moviedbassignment.helpers.RetrofitHelper
import com.example.moviedbassignment.viewmodel.MovieViewmodel
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MovieViewmodel

    lateinit var adapter: MovieRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        val daggerAppBinding = DaggerAppComponent.builder().build()
        daggerAppBinding.doInjection(this)
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        viewModel = MovieViewmodel(RetrofitHelper(BASE_URL,OkHttpClient()))
        activityMainBinding.movieViewModel = viewModel
        recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = MovieRecyclerAdapter()
        recyclerview.adapter = adapter
        getMovies()
    }

    fun getMovies() {
        viewModel.movieListData.observe(this, Observer { movieList ->
            movieList?.results?.let{
                adapter.updateList(it)
            }
        })
    }

    @BindingAdapter("bind:imgUrl")
    fun bindImage(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }
}
