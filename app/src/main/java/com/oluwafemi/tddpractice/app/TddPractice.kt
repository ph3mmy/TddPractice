package com.oluwafemi.tddpractice.app

import android.app.Application
import com.oluwafemi.tddpractice.di.AppComponent
import com.oluwafemi.tddpractice.di.DaggerAppComponent

class TddPractice : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
        appComponent.inject(this)
    }

    private fun initDI() {
        appComponent = DaggerAppComponent.builder().application(this).build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}