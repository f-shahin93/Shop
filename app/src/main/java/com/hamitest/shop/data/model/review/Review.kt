package com.hamitest.shop.data.model.review

import com.google.gson.annotations.SerializedName

data class Review(

    @field:SerializedName("reviewer_avatar_urls")
	val reviewerAvatar: ReviewerAvatar,

    @field:SerializedName("_links")
	val reviewLink: ReviewLink,

    @field:SerializedName("date_created")
	val dateCreated: String,

    @field:SerializedName("review")
	val review: String,

    @field:SerializedName("product_id")
	val productId: Int,

    @field:SerializedName("rating")
	val rating: Int,

    @field:SerializedName("verified")
	val verified: Boolean,

    @field:SerializedName("date_created_gmt")
	val dateCreatedGmt: String,

    @field:SerializedName("id")
	val id: Int,

    @field:SerializedName("reviewer")
	val reviewer: String,

    @field:SerializedName("reviewer_email")
	val reviewerEmail: String,

    @field:SerializedName("status")
	val status: String
)