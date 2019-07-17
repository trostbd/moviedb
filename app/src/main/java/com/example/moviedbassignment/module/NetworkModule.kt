package com.example.moviedbassignment.module

import com.example.moviedbassignment.helpers.BASE_URL
import com.example.moviedbassignment.helpers.RetrofitHelper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }

    @Provides
    fun provideService(retrofit: Retrofit): RetrofitHelper.RemoteService {
        return retrofit.create(RetrofitHelper.RemoteService::class.java)
    }
}