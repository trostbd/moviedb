package com.example.moviedbassignment.viewmodel

import android.arch.lifecycle.Observer
import com.example.moviedbassignment.helpers.RetrofitHelper
import com.example.moviedbassignment.model.Movie
import com.example.moviedbassignment.model.MovieList
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieViewmodelTest {

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewmodel = MovieViewmodel(helper)
    }

    lateinit var viewmodel: MovieViewmodel

    @Mock
    lateinit var helper: RetrofitHelper

    @Mock
    lateinit var observerMovieList: Observer<MovieList>

    @Test
    fun getMovieListData() {
    }

    @Test
    fun getMovieList() {
    }

    @Test
    fun getRetrofitHelper() {
    }
}