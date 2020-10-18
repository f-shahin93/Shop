package com.hamitest.shop.presenter.allproductlist

import com.hamitest.shop.data.model.product.ProductImage

class AllProductListItem(
    val name: String,
    val id: Int,
    val price: String,
    var regularPrice: String,
    val images: List<ProductImage>
)