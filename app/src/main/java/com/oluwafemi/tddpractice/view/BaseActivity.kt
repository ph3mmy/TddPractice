package com.oluwafemi.tddpractice.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setUpToolbar(toolbar: Toolbar, title: String) {
        toolbar.title = title
        setSupportActionBar(toolbar)
    }

    /*fun setUpToolbar(toolbar: Toolbar, title: String) {
        toolbar.title = title
        setSupportActionBar(toolbar)
    }*/
}