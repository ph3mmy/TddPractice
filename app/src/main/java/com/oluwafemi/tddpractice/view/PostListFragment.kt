package com.oluwafemi.tddpractice.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.oluwafemi.tddpractice.adapter.PostRecyclerListAdapter
import com.oluwafemi.tddpractice.app.TddPractice
import com.oluwafemi.tddpractice.databinding.FragmentPostListBinding
import com.oluwafemi.tddpractice.model.Post
import com.oluwafemi.tddpractice.view.PostDetailsFragment.Companion.KEY_POST
import com.oluwafemi.tddpractice.viewmodel.PostViewModel
import com.oluwafemi.tddpractice.viewmodel.PostViewModelFactory
import javax.inject.Inject

class PostListFragment: Fragment(), PostRecyclerListAdapter.PostClickListener {

    @Inject
    lateinit var viewModelFactory: PostViewModelFactory
    lateinit var binding: FragmentPostListBinding
    lateinit var viewModel: PostViewModel
    lateinit var postActivity: PostListActivity
    lateinit var adapter: PostRecyclerListAdapter


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is PostListActivity) {
            postActivity = context
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PostViewModel::class.java)

        viewModel.getAllPosts().observe(this,
            Observer<List<Post>> { t ->

                binding.pbPostList.visibility = View.GONE
                binding.rvAllPost.visibility = View.VISIBLE
                adapter.submitList(t)
            })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPostListBinding.inflate(inflater, container, false)

        TddPractice.appComponent.inject(this)

        adapter = PostRecyclerListAdapter(binding.root.context, this)
        binding.rvAllPost.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onPostClicked(post: Post) {
        val intent = Intent(postActivity, PostDetailActivity::class.java)
        intent.putExtra(KEY_POST, post.toString())
        startActivity(intent)
    }

    companion object {
        val TAG: String = PostListFragment::class.java.simpleName
    }
}