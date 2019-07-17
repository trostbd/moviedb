package com.example.moviedbassignment.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.example.moviedbassignment.helpers.RetrofitHelper
import com.example.moviedbassignment.model.MovieList

class MovieViewmodel(val retrofitHelper: RetrofitHelper) {

    val movieListData = MutableLiveData<MovieList>()//= retrofitHelper.retrieveMovieList()

    fun getMovieList() {
        Transformations.map(retrofitHelper.retrieveMovieList()) {
            movieListData.value = it
        }
    }
}