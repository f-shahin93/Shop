package com.hamitest.shop.presenter.home

import com.hamitest.shop.data.model.product.ProductImage


data class ProductItem (

    val name: String,
    val price: String,
    val images: List<ProductImage>,
    val id:Int
)