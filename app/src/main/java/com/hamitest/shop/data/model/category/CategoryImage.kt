package com.hamitest.shop.data.model.category

import com.google.gson.annotations.SerializedName

data class CategoryImage(

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