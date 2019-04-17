package com.oluwafemi.tddpractice.api_service

import com.oluwafemi.tddpractice.model.Comment
import com.oluwafemi.tddpractice.model.Post
import com.oluwafemi.tddpractice.model.author.Author
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("posts") // http://jsonplaceholder.typicode.com/posts
    fun getAllPosts(): Call<List<Post>>

    @GET("users") // http://jsonplaceholder.typicode.com/users
    fun getAllUsers(): Call<List<Post>>

    @GET("users") // http://jsonplaceholder.typicode.com/users
    fun getPostAuthor(@Query("id") userId : String): Call<List<Author>>

    @GET("comments") // http://jsonplaceholder.typicode.com/comments?postId=11
    fun getAllComments(@Query("postId") postId : String): Call<List<Comment>>
}