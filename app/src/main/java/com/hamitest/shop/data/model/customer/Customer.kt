package com.hamitest.shop.data.model.customer

import com.google.gson.annotations.SerializedName
import com.hamitest.shop.data.model.Billing
import com.hamitest.shop.data.model.Shipping

data class Customer(

    @field:SerializedName("date_modified_gmt")
	val dateModifiedGmt: String,

    @field:SerializedName("role")
	val role: String,

    @field:SerializedName("_links")
	val customerLink: CustomerLink,

    @field:SerializedName("date_created")
	val dateCreated: String,

    @field:SerializedName("last_name")
	val lastName: String,

    @field:SerializedName("date_created_gmt")
	val dateCreatedGmt: String,

    @field:SerializedName("billing")
	val billing: Billing,

    @field:SerializedName("date_modified")
	val dateModified: String,

    @field:SerializedName("shipping")
	val shipping: Shipping,

    @field:SerializedName("avatar_url")
	val avatarUrl: String,

    @field:SerializedName("meta_data")
	val metaData: List<Any>,

    @field:SerializedName("id")
	val id: Int,

    @field:SerializedName("first_name")
	val firstName: String,

    @field:SerializedName("email")
	val email: String,

    @field:SerializedName("is_paying_customer")
	val isPayingCustomer: Boolean,

    @field:SerializedName("username")
	val username: String
)


