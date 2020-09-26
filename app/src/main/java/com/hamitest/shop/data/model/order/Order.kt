package com.hamitest.shop.data.model.order

import com.google.gson.annotations.SerializedName
import com.hamitest.shop.data.model.Billing
import com.hamitest.shop.data.model.Shipping

data class Order(

	@field:SerializedName("discount_total")
	val discountTotal: String,

	@field:SerializedName("order_key")
	val orderKey: String,

	@field:SerializedName("prices_include_tax")
	val pricesIncludeTax: Boolean,

	@field:SerializedName("_links")
	val orderLink: OrderLink,

	@field:SerializedName("customer_note")
	val customerNote: String,

	@field:SerializedName("line_items")
	val lineItemListOrderProducts: List<ListOrderProduct>,

	@field:SerializedName("coupon_lines")
	val couponLines: List<Any>,

	@field:SerializedName("billing")
	val billing: Billing,

	@field:SerializedName("refunds")
	val refunds: List<Any>,

	@field:SerializedName("number")
	val number: String,

	@field:SerializedName("total")
	val total: String,

	@field:SerializedName("shipping")
	val shipping: Shipping,

	@field:SerializedName("date_paid_gmt")
	val datePaidGmt: Any,

	@field:SerializedName("tax_lines")
	val taxLines: List<Any>,

	@field:SerializedName("date_paid")
	val datePaid: Any,

	@field:SerializedName("customer_user_agent")
	val customerUserAgent: String,

	@field:SerializedName("payment_method_title")
	val paymentMethodTitle: String,

	@field:SerializedName("meta_data")
	val metaData: List<Any>,

	@field:SerializedName("date_completed")
	val dateCompleted: Any,

	@field:SerializedName("currency")
	val currency: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("date_completed_gmt")
	val dateCompletedGmt: Any,

	@field:SerializedName("payment_method")
	val paymentMethod: String,

	@field:SerializedName("shipping_tax")
	val shippingTax: String,

	@field:SerializedName("transaction_id")
	val transactionId: String,

	@field:SerializedName("date_modified_gmt")
	val dateModifiedGmt: String,

	@field:SerializedName("cart_hash")
	val cartHash: String,

	@field:SerializedName("shipping_total")
	val shippingTotal: String,

	@field:SerializedName("cart_tax")
	val cartTax: String,

	@field:SerializedName("currency_symbol")
	val currencySymbol: String,

	@field:SerializedName("created_via")
	val createdVia: String,

	@field:SerializedName("date_created")
	val dateCreated: String,

	@field:SerializedName("date_created_gmt")
	val dateCreatedGmt: String,

	@field:SerializedName("discount_tax")
	val discountTax: String,

	@field:SerializedName("total_tax")
	val totalTax: String,

	@field:SerializedName("version")
	val version: String,

	@field:SerializedName("customer_ip_address")
	val customerIpAddress: String,

	@field:SerializedName("shipping_lines")
	val shippingLines: List<Any>,

	@field:SerializedName("date_modified")
	val dateModified: String,

	@field:SerializedName("parent_id")
	val parentId: Int,

	@field:SerializedName("fee_lines")
	val feeLines: List<Any>,

	@field:SerializedName("customer_id")
	val customerId: Int,

	@field:SerializedName("status")
	val status: String
)

