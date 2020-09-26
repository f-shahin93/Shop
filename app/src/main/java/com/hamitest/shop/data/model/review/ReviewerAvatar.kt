package com.hamitest.shop.data.model.review

import com.google.gson.annotations.SerializedName

data class ReviewerAvatar(

	@field:SerializedName("24")
	val size24: String,

	@field:SerializedName("48")
	val size48: String,

	@field:SerializedName("96")
	val size96: String
)