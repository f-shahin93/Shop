package com.hamitest.shop.data.mapper

import com.hamitest.shop.data.model.category.Category
import com.hamitest.shop.data.model.product.Product
import com.hamitest.shop.presenter.allProductList.AllProductListItem
import com.hamitest.shop.presenter.category.SubCategoryItem
import com.hamitest.shop.presenter.home.ParentCategoryItem
import com.hamitest.shop.presenter.home.ProductItem
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapToProductHomeEntity(productDto: Product): ProductItem {
        return ProductItem(
            productDto.name,
            productDto.price,
            productDto.images,
            productDto.id
        )
    }

    fun mapToAllProductListItemEntity(product: Product): AllProductListItem {
        return AllProductListItem(
            product.name,
            product.id,
            product.price,
            product.regularPrice,
            product.images
        )
    }

    fun mapToCategoryHomeEntity(category: Category): ParentCategoryItem {
        return ParentCategoryItem(
            category.name,
            category.id
        )
    }


    fun mapToCategoryPageEntity(category: Category): SubCategoryItem {
        return SubCategoryItem(category.name, category.id, category.categoryImage)
    }

    /** Map Category List To ParentCategoryItem List */
    fun mapToCategoryItemList(list: List<Category>): List<ParentCategoryItem> {
        var listItem = ArrayList<ParentCategoryItem>()
        for (i in list) {
            listItem.add(mapToCategoryHomeEntity(i))
        }
        return listItem
    }

    /** Map Product List To ProductItem List */
    fun mapToProductItemList(list: List<Product>): List<ProductItem> {
        var listItem = ArrayList<ProductItem>()
        for (i in list) {
            listItem.add(mapToProductHomeEntity(i))
        }
        return listItem
    }

    /** product list of subCategory */
    fun mapToAllProductListItemList(list: List<Product>): List<AllProductListItem> {
        var listItem = ArrayList<AllProductListItem>()
        for (i in list) {
            listItem.add(mapToAllProductListItemEntity(i))
        }
        return listItem
    }

}