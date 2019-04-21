package com.oluwafemi.tddpractice.model.author

import com.google.gson.annotations.SerializedName

class Company {

    @SerializedName("bs")
    var bs: String? = null
    @SerializedName("catchPhrase")
    var catchPhrase: String? = null
    @SerializedName("name")
    var name: String? = null

}
