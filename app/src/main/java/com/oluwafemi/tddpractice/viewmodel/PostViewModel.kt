package com.oluwafemi.tddpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oluwafemi.tddpractice.model.Post
import com.oluwafemi.tddpractice.repository.PostRepository

class PostViewModel: ViewModel() {

    var repository: PostRepository = PostRepository()

    fun getAllPosts(): LiveData<List<Post>> {
        return repository.getAllPosts()
    }
}