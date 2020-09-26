package com.hamitest.shop.data.model.order

import com.google.gson.annotations.SerializedName

data class OrderCustomerUrl(

	@field:SerializedName("href")
	val href: String
)