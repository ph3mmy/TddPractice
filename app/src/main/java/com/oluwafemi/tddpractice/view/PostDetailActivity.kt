package com.oluwafemi.tddpractice.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.oluwafemi.tddpractice.R
import com.oluwafemi.tddpractice.databinding.ActivityPostDetailsBinding
import com.oluwafemi.tddpractice.view.PostDetailsFragment.Companion.KEY_POST

class PostDetailActivity: BaseActivity() {

    lateinit var binding: ActivityPostDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_details)

        val bundle = intent.extras
        val postString = bundle?.getString(KEY_POST)

        val fragment = PostDetailsFragment.newInstance(postString!!)
        switchFragment(fragment, "post_detail_frag")
    }

    private fun switchFragment(fragment: Fragment, tag: String) {
        val fm: FragmentManager = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.frame_post_details, fragment, tag)
        ft.commit()
    }

    companion object {
        val TAG: String = PostDetailActivity::class.java.simpleName
    }

}