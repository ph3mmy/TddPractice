package com.oluwafemi.tddpractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oluwafemi.tddpractice.R
import com.oluwafemi.tddpractice.databinding.RowItemCommentListBinding
import com.oluwafemi.tddpractice.model.Comment
import com.oluwafemi.tddpractice.model.Post

class CommentRecyclerListAdapter():
    ListAdapter<Comment, CommentRecyclerListAdapter.ViewHolder>(CommentDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<RowItemCommentListBinding>(LayoutInflater.from(parent.context),
            R.layout.row_item_comment_list, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: RowItemCommentListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comment: Comment) {
            binding.comment = comment
            binding.executePendingBindings()
        }
    }

    interface PostClickListener {
        fun onPostClicked(post: Post)
    }

}