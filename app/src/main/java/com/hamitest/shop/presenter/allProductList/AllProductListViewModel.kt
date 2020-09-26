package com.hamitest.shop.presenter.allProductList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.hamitest.shop.data.mapper.Mapper
import com.hamitest.shop.data.repository.ProductRepository
import com.hamitest.shop.presenter.Utils.ShopConstant
import kotlinx.coroutines.launch
import javax.inject.Inject

class AllProductListViewModel @Inject constructor(
    var productRepository: ProductRepository,
    var mapper: Mapper
) : ViewModel() {


    fun getProductsOfSubCategory(statusMap: HashMap<String, String>): MutableLiveData<List<AllProductListItem>> {
        var productListOfSubCategory = MutableLiveData<List<AllProductListItem>>()

        viewModelScope.launch {
            when (val either = productRepository.getAllProductsOfSubCategory(statusMap)) {
                is Either.Right -> productListOfSubCategory.value =
                    mapper.mapToAllProductListItemList(either.b)
                is Either.Left -> ShopConstant.showError(either.a)
            }
        }

        return productListOfSubCategory
    }

}