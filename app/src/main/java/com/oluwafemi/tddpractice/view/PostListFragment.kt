package com.oluwafemi.tddpractice.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.oluwafemi.tddpractice.databinding.FragmentPostListBinding
import com.oluwafemi.tddpractice.model.Post
import com.oluwafemi.tddpractice.viewmodel.PostViewModel

class PostListFragment: Fragment() {

    lateinit var mView: View
    lateinit var binding: FragmentPostListBinding
    lateinit var viewModel: PostViewModel
    lateinit var postActivity: PostActivity


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is PostActivity) {
            postActivity = context
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPostListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)

        viewModel.getAllPosts().observe(this,
            Observer<List<Post>> { t ->
                Log.e(TAG, "Size of list == ${t?.size}")
                bindPostsToRecyclerView(t)
            })

        return binding.root
    }

    private fun bindPostsToRecyclerView(posts: List<Post>?) {



    }

    companion object {
        val TAG: String = PostListFragment::class.java.simpleName
    }
}