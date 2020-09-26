package com.hamitest.shop.presenter.shoppingcart

import com.hamitest.shop.data.model.product.ProductImage

data class CartProductItem(
    val name : String,
    val id : Int,
    val price : Int,
    var shortDescription: String,
    var regularPrice: String,
    var salePrice: String,
    val images: List<ProductImage>
)