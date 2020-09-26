package com.hamitest.shop.data.model.customer

import com.google.gson.annotations.SerializedName
import com.hamitest.shop.data.model.CollectionUrl
import com.hamitest.shop.data.model.SelfUrl

data class CustomerLink(

    @field:SerializedName("self")
	val selfUrl: List<SelfUrl>,

    @field:SerializedName("collection")
	val collectionUrl: List<CollectionUrl>
)