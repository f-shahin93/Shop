package com.hamitest.shop.data.model.order

import com.google.gson.annotations.SerializedName

data class ListOrderProduct(

	@field:SerializedName("quantity")
	val quantity: Int,

	@field:SerializedName("tax_class")
	val taxClass: String,

	@field:SerializedName("taxes")
	val taxes: List<Any>,

	@field:SerializedName("total_tax")
	val totalTax: String,

	@field:SerializedName("total")
	val total: String,

	@field:SerializedName("variation_id")
	val variationId: Int,

	@field:SerializedName("subtotal")
	val subtotal: String,

	@field:SerializedName("price")
	val price: Int,

	@field:SerializedName("product_id")
	val productId: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("meta_data")
	val metaData: List<Any>,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("subtotal_tax")
	val subtotalTax: String,

	@field:SerializedName("sku")
	val sku: String
)