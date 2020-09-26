package com.hamitest.shop.data.model.order

import com.google.gson.annotations.SerializedName
import com.hamitest.shop.data.model.CollectionUrl
import com.hamitest.shop.data.model.SelfUrl

data class OrderLink(

    @field:SerializedName("self")
	val selfUrl: List<SelfUrl>,

    @field:SerializedName("collection")
	val collectionUrl: List<CollectionUrl>,

    @field:SerializedName("customer")
	val customerCustomerUrl: List<OrderCustomerUrl>
)