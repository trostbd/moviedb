package com.example.moviedbassignment.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.example.moviedbassignment.helpers.RetrofitHelper
import com.example.moviedbassignment.model.Movie
import com.example.moviedbassignment.model.MovieList
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
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

    @Test
    fun getMovieListData() {
        val livedata = MutableLiveData<MovieList>()
        Mockito.`when`(helper.retrieveMovieList()).thenReturn(livedata)
        viewmodel.getMovieList()
        verify(viewmodel.movieListData.value)?.equals(livedata.value)
    }
}