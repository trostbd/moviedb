package com.example.moviedbassignment.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviedbassignment.R
import com.example.moviedbassignment.databinding.MovieBinding
import com.example.moviedbassignment.model.Movie

class MovieRecyclerAdapter: RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder>() {

    val movieList: MutableList<Movie> = mutableListOf()

    var pageIndex = 1

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.movie,p0,false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val movie = movieList[p1]
        p0.movieBinding?.movieObj = movie
        p0.movieBinding?.movieAdapter = this
        p0.movieBinding?.executePendingBindings()
    }

    fun updateList(newMovies: Collection<Movie>) {
        movieList.addAll(newMovies)
        pageIndex++
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val movieBinding = DataBindingUtil.bind<MovieBinding>(itemView)
    }
}