package com.oluwafemi.tddpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oluwafemi.tddpractice.model.Post
import com.oluwafemi.tddpractice.model.author.Author
import com.oluwafemi.tddpractice.repository.PostRepository

class PostViewModel: ViewModel() {

    var repository: PostRepository = PostRepository()

    fun getAllPosts(): LiveData<List<Post>> {
        return repository.getAllPosts()
    }

    fun getPostAuthor(userId: String): LiveData<Author>  {
        return repository.getPostAuthor(userId)
    }

    fun getAuthorFormattedPhoneWebsite(author: Author): String? {
        return author.phone + " || http://" + author.website
    }
}