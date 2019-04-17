package com.oluwafemi.tddpractice.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.gson.Gson
import com.oluwafemi.tddpractice.R
import com.oluwafemi.tddpractice.databinding.ActivityPostDetailsBinding
import com.oluwafemi.tddpractice.model.Post
import com.oluwafemi.tddpractice.view.PostDetailsFragment.Companion.KEY_POST
import com.oluwafemi.tddpractice.viewmodel.PostViewModel

class PostDetailActivity: BaseActivity() {

    lateinit var binding: ActivityPostDetailsBinding
    lateinit var post:Post
    lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_details)
        viewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)

        val bundle = intent.extras
        val postString = bundle?.getString(KEY_POST)

        val gson = Gson()
        post = gson.fromJson(postString, Post::class.java)
        setUpToolbar(binding.toolbar)

        setupCommentBottomSheet()

        fetchPostAuthorDetail(post.userId)
    }

    private fun setupCommentBottomSheet() {
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.clBottomSheet)
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {

            }

            override fun onStateChanged(p0: View, p1: Int) {

            }

        })

    }

    private fun fetchPostAuthorDetail(userId: String?) {
        viewModel.getPostAuthor(userId!!).observe(this@PostDetailActivity, Observer {
            binding.isAuthorLoaded = true
            binding.author = it
            binding.post = post
            binding.viewmodel = viewModel
            binding.executePendingBindings()
        })
    }

    fun setUpToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Glide.with(this)
            .load("http://lorempixel.com/400/200/nature/"+post.userId)
            .into(binding.ivPost)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    companion object {
        val TAG: String = PostDetailActivity::class.java.simpleName
    }

}