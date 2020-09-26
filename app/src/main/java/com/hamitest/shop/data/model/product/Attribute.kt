package com.hamitest.shop.data.model.product

import com.google.gson.annotations.SerializedName

data class Attribute(

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("name")
    val name: String,

    @SerializedName("position")
    val position: Int,

    @SerializedName("visible")
    val visible: Boolean,


    @SerializedName("variation")
    val variation: Boolean,

    @SerializedName("options")
    val options: List<String>
)