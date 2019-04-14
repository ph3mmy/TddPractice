package com.oluwafemi.tddpractice.adapter

//import androidx.databinding.ViewDataBinding
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oluwafemi.tddpractice.R
import com.oluwafemi.tddpractice.databinding.RowItemPostListBinding
import com.oluwafemi.tddpractice.model.Post

class PostListAdapter(private var posts: List<Post>): RecyclerView.Adapter<PostListAdapter.PostViewHolder>() {

//    var posts: ArrayList<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RowItemPostListBinding = DataBindingUtil.inflate(inflater, R.layout.row_item_post_list, parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.e("AD", "getItem size == ${posts.size}")
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        Log.e("ADAD", "size of posts == " + posts.size)
        holder.bind(posts[position])
    }


    /*fun add(r: Post) {
        posts.add(r)
        notifyItemInserted(posts.size - 1)
    }

    fun addPosts(posts: List<Post>) {
        Log.e("ADAD", "size passed == ${posts.size}")
        this.posts.clear()
        for (post in posts) {
            add(post)
        }
    }*/


    class PostViewHolder(val binding: RowItemPostListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post){
            Log.e("PH", "Post == ${post.title}")
            binding.post = post
            binding.executePendingBindings()
        }
    }
}