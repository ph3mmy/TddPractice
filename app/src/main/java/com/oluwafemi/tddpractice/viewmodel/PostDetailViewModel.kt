package com.oluwafemi.tddpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oluwafemi.tddpractice.model.Comment
import com.oluwafemi.tddpractice.model.author.Author
import com.oluwafemi.tddpractice.repository.PostRepository
import javax.inject.Inject

class PostDetailViewModel @Inject constructor(private val repository: PostRepository): ViewModel() {

    fun getPostAuthor(userId: String): LiveData<Author>  {
        return repository.getPostAuthor(userId)
    }

    fun getPostComments(postId: String): LiveData<List<Comment>>  {
        return repository.getPostComments(postId)
    }

    fun getAuthorFormattedPhoneWebsite(author: Author): String? {
        return author.phone + " || http://" + author.website
    }
}