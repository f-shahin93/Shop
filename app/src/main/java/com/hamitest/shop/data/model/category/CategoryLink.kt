package com.hamitest.shop.data.model.category

import com.google.gson.annotations.SerializedName
import com.hamitest.shop.data.model.CollectionUrl
import com.hamitest.shop.data.model.SelfUrl

data class CategoryLink(

    @field:SerializedName("self")
	val selfUrl: List<SelfUrl>,

    @field:SerializedName("collection")
	val collectionUrl: List<CollectionUrl>
)