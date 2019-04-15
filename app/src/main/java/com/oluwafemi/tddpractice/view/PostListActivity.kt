package com.oluwafemi.tddpractice.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.oluwafemi.tddpractice.R
import com.oluwafemi.tddpractice.databinding.ActivityMainBinding

class PostListActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val fragment = PostListFragment()
        switchFragment(fragment, "post_list")
    }

    private fun switchFragment(fragment: Fragment, tag: String) {
        val fm: FragmentManager = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.frame_post, fragment, tag)
        ft.commit()
    }
}
