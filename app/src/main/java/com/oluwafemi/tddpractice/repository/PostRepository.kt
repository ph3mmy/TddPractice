package com.oluwafemi.tddpractice.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.oluwafemi.tddpractice.api_service.ApiUtils
import com.oluwafemi.tddpractice.model.Post
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call


class PostRepository {

    lateinit var allPostLiveData: MutableLiveData<List<Post>>
    val retrofitClient = ApiUtils.getApiService()

    fun getAllPosts(): LiveData<List<Post>> {
        allPostLiveData = MutableLiveData()
        retrofitClient?.getAllPosts()?.enqueue(object: Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                Log.e("REPO" ,"error == ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful && response.body() != null) {
                    Log.e("REPO" ,"REPO size of Post == ${response.body()?.size}")
                    allPostLiveData.value = response.body()
                }
            }

        })
        return allPostLiveData

    }

}