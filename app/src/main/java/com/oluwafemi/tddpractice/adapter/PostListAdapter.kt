package com.oluwafemi.tddpractice.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.oluwafemi.tddpractice.model.Post

class PostListAdapter(): RecyclerView.Adapter<PostListAdapter.PostViewHolder>() {

    var posts: MutableList<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun addPosts(posts: List<Post>) {
//        for (post in Posts)
    }


    class PostViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post){

        }
    }
}