package com.hamitest.shop.data.model.product

import com.google.gson.annotations.SerializedName


data class Product(

    @SerializedName("upsell_ids")
	val upsellIds: List<Any>,

    @field:SerializedName("featured")
	val featured: Boolean,

    @field:SerializedName("purchasable")
	val purchasable: Boolean,

    @field:SerializedName("grouped_products")
	val groupedProducts: List<Any>,

    @field:SerializedName("_links")
	val link: ProductLink,

    @field:SerializedName("tax_status")
	val taxStatus: String,

    @field:SerializedName("catalog_visibility")
	val catalogVisibility: String,

    @field:SerializedName("type")
	val type: String,

    @field:SerializedName("external_url")
	val externalUrl: String,

    @field:SerializedName("price")
	val price: String,

    @field:SerializedName("meta_data")
	val metaData: List<MetaData>,

    @field:SerializedName("id")
	val id: Int,

    @field:SerializedName("sku")
	val sku: String,

    @field:SerializedName("slug")
	val slug: String,

    @field:SerializedName("date_on_sale_from")
	val dateOnSaleFrom: Any,

    @field:SerializedName("shipping_required")
	val shippingRequired: Boolean,

    @field:SerializedName("date_modified_gmt")
	val dateModifiedGmt: String,

    @field:SerializedName("images")
	val images: List<ProductImage>,

    @field:SerializedName("stock_status")
	val stockStatus: String,

    @field:SerializedName("price_html")
	val priceHtml: String,

    @field:SerializedName("download_expiry")
	val downloadExpiry: Int,

    @field:SerializedName("backordered")
	val backordered: Boolean,

    @field:SerializedName("weight")
	val weight: String,

    @field:SerializedName("rating_count")
	val ratingCount: Int,

    @field:SerializedName("tags")
	val tags: List<ProductTag>,

    @field:SerializedName("date_on_sale_to")
	val dateOnSaleTo: Any,

    @field:SerializedName("sold_individually")
	val soldIndividually: Boolean,

    @field:SerializedName("backorders")
	val backorders: String,

    @field:SerializedName("shipping_taxable")
	val shippingTaxable: Boolean,

    @field:SerializedName("parent_id")
	val parentId: Int,

    @field:SerializedName("download_limit")
	val downloadLimit: Int,

    @field:SerializedName("name")
	val name: String,

    @field:SerializedName("shipping_class")
	val shippingClass: String,

    @field:SerializedName("button_text")
	val buttonText: String,

    @field:SerializedName("permalink")
	val permalink: String,

    @field:SerializedName("status")
	val status: String,

    @field:SerializedName("cross_sell_ids")
	val crossSellIds: List<Any>,

    @field:SerializedName("short_description")
	val shortDescription: String,

    @field:SerializedName("virtual")
	val virtual: Boolean,

    @field:SerializedName("downloadable")
	val downloadable: Boolean,

    @field:SerializedName("menu_order")
	val menuOrder: Int,

    @field:SerializedName("description")
	val description: String,

    @field:SerializedName("date_on_sale_to_gmt")
	val dateOnSaleToGmt: Any,

    @field:SerializedName("date_on_sale_from_gmt")
	val dateOnSaleFromGmt: Any,

    @field:SerializedName("regular_price")
	val regularPrice: String,

    @field:SerializedName("backorders_allowed")
	val backordersAllowed: Boolean,

    @field:SerializedName("downloads")
	val downloads: List<Any>,

    @field:SerializedName("reviews_allowed")
	val reviewsAllowed: Boolean,

    @field:SerializedName("variations")
	val variations: List<Any>,

    @field:SerializedName("categories")
	val categories: List<ProductCategory>,

    @field:SerializedName("total_sales")
	val totalSales: Int,

    @field:SerializedName("on_sale")
	val onSale: Boolean,

    @field:SerializedName("manage_stock")
	val manageStock: Boolean,

    @field:SerializedName("default_attributes")
	val defaultAttributes: List<Any>,

    @field:SerializedName("purchase_note")
	val purchaseNote: String,

    @field:SerializedName("date_created")
	val dateCreated: String,

    @field:SerializedName("tax_class")
	val taxClass: String,

    @field:SerializedName("date_created_gmt")
	val dateCreatedGmt: String,

    @field:SerializedName("average_rating")
	val averageRating: String,

    @field:SerializedName("stock_quantity")
	val stockQuantity: Any,

    @field:SerializedName("sale_price")
	val salePrice: String,

    @field:SerializedName("shipping_class_id")
	val shippingClassId: Int,

    @field:SerializedName("date_modified")
	val dateModified: String,

    @field:SerializedName("related_ids")
	val relatedIds: List<Int>,

    @field:SerializedName("attributes")
	val attributes: List<Attribute>,

    @field:SerializedName("dimensions")
	val dimension: ProductDimension
)