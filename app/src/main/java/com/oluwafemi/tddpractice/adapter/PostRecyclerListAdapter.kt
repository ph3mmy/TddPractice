package com.oluwafemi.tddpractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oluwafemi.tddpractice.R
import com.oluwafemi.tddpractice.databinding.RowItemPostListBinding
import com.oluwafemi.tddpractice.model.Post

class PostRecyclerListAdapter(val context: Context, private val clickListener: PostClickListener):
    ListAdapter<Post, PostRecyclerListAdapter.ViewHolder>(PostDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<RowItemPostListBinding>(LayoutInflater.from(parent.context),
            R.layout.row_item_post_list, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), this)
    }

    fun getTitleFirstLetter(post: Post): String {
        return post.title!![0].toUpperCase().toString()
    }

    fun setClickListener(post: Post) {
        clickListener.onPostClicked(post)
    }


    class ViewHolder(private val binding: RowItemPostListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post, adapter: PostRecyclerListAdapter) {
            binding.post = post
            binding.adapter = adapter
            binding.executePendingBindings()
        }
    }

    interface PostClickListener {
        fun onPostClicked(post: Post)
    }

}