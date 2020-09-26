package com.hamitest.shop.data.model.product

import com.google.gson.annotations.SerializedName

data class ProductImage(

	@field:SerializedName("date_modified_gmt")
	val dateModifiedGmt: String,

	@field:SerializedName("date_modified")
	val dateModified: String,

	@field:SerializedName("src")
	val src: String,

	@field:SerializedName("date_created")
	val dateCreated: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("alt")
	val alt: String,

	@field:SerializedName("date_created_gmt")
	val dateCreatedGmt: String,

	@field:SerializedName("id")
	val id: Int
)