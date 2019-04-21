package com.oluwafemi.tddpractice.model.author

import com.google.gson.annotations.SerializedName

class Address {

    @SerializedName("city")
    var city: String? = null
    @SerializedName("geo")
    var geo: Geo? = null
    @SerializedName("street")
    var street: String? = null
    @SerializedName("suite")
    var suite: String? = null
    @SerializedName("zipcode")
    var zipcode: String? = null


    data class Geo(
        @field:SerializedName("lat")
        var lat: String? = null,
        @SerializedName("lng") var lng: String? = null)

}
