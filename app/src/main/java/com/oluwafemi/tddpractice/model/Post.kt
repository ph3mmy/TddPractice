package com.oluwafemi.tddpractice.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class Post {

    @SerializedName("userId")
    var userId: String? = null

    @SerializedName("id")
    var id: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("body")
    var body: String? = null

    override fun toString(): String {
        return Gson().toJson(this)
    }

}