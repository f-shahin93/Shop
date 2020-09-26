package com.hamitest.shop.data.model

import com.google.gson.annotations.SerializedName

data class Shipping(

	@field:SerializedName("country")
	val country: String,

	@field:SerializedName("city")
	val city: String,

	@field:SerializedName("address_1")
	val address1: String,

	@field:SerializedName("address_2")
	val address2: String,

	@field:SerializedName("postcode")
	val postcode: String,

	@field:SerializedName("last_name")
	val lastName: String,

	@field:SerializedName("company")
	val company: String,

	@field:SerializedName("state")
	val state: String,

	@field:SerializedName("first_name")
	val firstName: String
)