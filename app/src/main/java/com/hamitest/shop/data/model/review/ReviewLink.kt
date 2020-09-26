package com.hamitest.shop.data.model.review

import com.google.gson.annotations.SerializedName
import com.hamitest.shop.data.model.CollectionUrl
import com.hamitest.shop.data.model.SelfUrl

data class ReviewLink(

    @field:SerializedName("self")
	val selfUrl: List<SelfUrl>,

    @field:SerializedName("collection")
	val collectionUrl: List<CollectionUrl>,

    @field:SerializedName("up")
	val up: List<ReviewProductUrl>
)