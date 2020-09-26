package com.hamitest.shop.data.model.product

import com.google.gson.annotations.SerializedName

data class ProductCategory(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("slug")
	val slug: String
)