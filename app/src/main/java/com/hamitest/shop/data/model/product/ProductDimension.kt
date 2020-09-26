package com.hamitest.shop.data.model.product

import com.google.gson.annotations.SerializedName

data class ProductDimension(

	@field:SerializedName("length")
	val length: String,

	@field:SerializedName("width")
	val width: String,

	@field:SerializedName("height")
	val height: String
)