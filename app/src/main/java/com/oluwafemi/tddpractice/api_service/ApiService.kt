package com.oluwafemi.tddpractice.api_service

import com.oluwafemi.tddpractice.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts") // http://jsonplaceholder.typicode.com/posts
    fun getAllPosts(): Call<List<Post>>

    @GET("users") // http://jsonplaceholder.typicode.com/users
    fun getAllUsers(): Call<List<Post>>

    @GET("comments") // http://jsonplaceholder.typicode.com/comments
    fun getAllComments(): Call<List<Post>>
}