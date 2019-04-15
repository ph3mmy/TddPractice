package com.oluwafemi.tddpractice.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.oluwafemi.tddpractice.api_service.ApiUtils
import com.oluwafemi.tddpractice.model.Post
import com.oluwafemi.tddpractice.model.author.Author
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostRepository {

    lateinit var allPostLiveData: MutableLiveData<List<Post>>
    lateinit var authorLiveData: MutableLiveData<Author>
    private val retrofitClient = ApiUtils.getApiService()

    fun getAllPosts(): LiveData<List<Post>> {
        allPostLiveData = MutableLiveData()
        retrofitClient?.getAllPosts()?.enqueue(object: Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful && response.body() != null) {
                    allPostLiveData.value = response.body()
                }
            }

        })
        return allPostLiveData

    }

    fun getPostAuthor(userId: String): LiveData<Author> {
        authorLiveData = MutableLiveData()
        retrofitClient?.getPostAuthor(userId)?.enqueue(object: Callback<List<Author>> {
            override fun onFailure(call: Call<List<Author>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Author>>, response: Response<List<Author>>) {
                if (response.isSuccessful && response.body() != null) {
                    authorLiveData.value = response.body()!![0]
                }
            }

        })
        return authorLiveData

    }

}