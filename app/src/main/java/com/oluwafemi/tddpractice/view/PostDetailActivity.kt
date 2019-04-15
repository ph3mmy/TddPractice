package com.oluwafemi.tddpractice.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.oluwafemi.tddpractice.R
import com.oluwafemi.tddpractice.databinding.ActivityPostDetailsBinding
import com.oluwafemi.tddpractice.model.Post
import com.oluwafemi.tddpractice.view.PostDetailsFragment.Companion.KEY_POST

class PostDetailActivity: BaseActivity() {

    lateinit var binding: ActivityPostDetailsBinding
    lateinit var post:Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_details)

        val bundle = intent.extras
        val postString = bundle?.getString(KEY_POST)

        val gson = Gson()
        post = gson.fromJson(postString, Post::class.java)
        setUpToolbar(binding.toolbar)
        fetchPostAuthorDetail(post.userId)
    }

    private fun fetchPostAuthorDetail(userId: String?) {


    }

    fun setUpToolbar(toolbar: Toolbar) {
        Log.e(TAG, "passed toobar == $toolbar")

        binding.collapsingToolbar.title = post.title

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Glide.with(this)
            .load("http://lorempixel.com/400/200/nature")
            .into(binding.ivPost)
    }


    companion object {
        val TAG: String = PostDetailActivity::class.java.simpleName
    }

}