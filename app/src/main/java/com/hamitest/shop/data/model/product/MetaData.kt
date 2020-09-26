package com.hamitest.shop.data.model.product

import com.google.gson.annotations.SerializedName

data class MetaData(

    @SerializedName("id")
    var id: Int,

    @SerializedName("value")
    val value: String,

    @SerializedName("key")
    val key: String
)