package com.example.moviedbassignment.helpers

import android.arch.lifecycle.MutableLiveData
import com.example.moviedbassignment.model.Movie
import com.example.moviedbassignment.model.MovieList
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RetrofitHelper(url: String, client: OkHttpClient) {

    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    val service = retrofit.create(RemoteService::class.java)

    fun retrieveMovieList(): MutableLiveData<MovieList> {
        val call =service.getMovies(API_KEY, LANGUAGE_ENGLISH, SORT_BY_POP_DESC, INCLUDE_ADULT_FALSE, INCLUDE_VIDEO_FALSE, PAGE_COUNT)
        val movieListData =MutableLiveData<MovieList>()
        call.enqueue(object: Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                t.printStackTrace()
                movieListData.value = MovieList(ArrayList<Movie>())
            }

            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                if(response.body()!= null) {
                    movieListData.value = response.body()
                }
            }

        })
        return movieListData
    }

    interface RemoteService {
        @GET("discover/movie")
        fun getMovies(@Query("api_key")api_key: String, @Query("language")language: String,
                      @Query("sort_by")sort_by: String, @Query("include_adult")include_adult: Boolean,
                      @Query("include_video")include_video: Boolean, @Query("page")page: Int): Call<MovieList>
    }
}