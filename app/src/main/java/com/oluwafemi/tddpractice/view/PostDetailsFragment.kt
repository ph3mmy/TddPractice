package com.oluwafemi.tddpractice.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.oluwafemi.tddpractice.databinding.FragmentPostDetailsBinding
import com.oluwafemi.tddpractice.model.Post

class PostDetailsFragment: Fragment() {

    lateinit var binding: FragmentPostDetailsBinding
    lateinit var post: Post

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPostDetailsBinding.inflate(inflater, container, false)
        val bundle = arguments
        val postStr: String? = bundle?.getString(KEY_POST)
        val gson = Gson()
        post = gson.fromJson(postStr, Post::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "our passed post == $post")
    }

    companion object {
        val TAG: String = PostDetailsFragment::class.java.simpleName

        val KEY_POST: String = "post_key"

        fun newInstance(postString: String): PostDetailsFragment {
            val fragment = PostDetailsFragment()
            Log.e(TAG, "passed post == ${postString}")
            val args = Bundle()
            args.putString(KEY_POST, postString)

            fragment.arguments = args
            return fragment
        }
    }
}