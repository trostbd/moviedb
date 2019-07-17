package com.example.moviedbassignment.component

import com.example.moviedbassignment.module.NetworkModule
import com.example.moviedbassignment.view.MainActivity
import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun doInjection(activity: MainActivity)
}