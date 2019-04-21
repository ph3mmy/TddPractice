package com.oluwafemi.tddpractice.model

import com.google.gson.annotations.SerializedName

class Comment {

    @SerializedName("body")
    var body: String? = null
    @SerializedName("email")
    var email: String? = null
    @SerializedName("id")
    var id: Long? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("postId")
    var postId: Long? = null

}
