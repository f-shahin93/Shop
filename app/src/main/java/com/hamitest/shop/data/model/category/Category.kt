package com.hamitest.shop.data.model.category

import com.google.gson.annotations.SerializedName

data class Category(

    @field:SerializedName("parent")
	val parent: Int,

    @field:SerializedName("image")
	val categoryImage: CategoryImage,

    @field:SerializedName("menu_order")
	val menuOrder: Int,

    @field:SerializedName("_links")
	val categoryLink: CategoryLink,

    @field:SerializedName("display")
	val display: String,

    @field:SerializedName("name")
	val name: String,

    @field:SerializedName("count")
	val count: Int,

    @field:SerializedName("description")
	val description: String,

    @field:SerializedName("id")
	val id: Int,

    @field:SerializedName("slug")
	val slug: String
)

