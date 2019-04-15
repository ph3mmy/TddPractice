package com.oluwafemi.tddpractice.model.author

import com.google.gson.annotations.SerializedName

class Geo {

    @SerializedName("lat")
    var lat: String? = null
    @SerializedName("lng")
    var lng: String? = null

}
