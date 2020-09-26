package com.hamitest.shop.data.model.product

import com.google.gson.annotations.SerializedName
import com.hamitest.shop.data.model.CollectionUrl
import com.hamitest.shop.data.model.SelfUrl

data class ProductLink(

    @field:SerializedName("self")
	val selfUrl: List<SelfUrl>,

    @field:SerializedName("collection")
	val collectionUrl: List<CollectionUrl>
)