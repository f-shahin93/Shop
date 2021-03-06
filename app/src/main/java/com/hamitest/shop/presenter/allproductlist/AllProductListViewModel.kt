package com.hamitest.shop.presenter.allproductlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.hamitest.shop.data.mapper.Mapper
import com.hamitest.shop.data.repository.ProductRemoteRepository
import com.hamitest.shop.presenter.utils.ShopConstant
import kotlinx.coroutines.launch
import javax.inject.Inject

class AllProductListViewModel @Inject constructor(
    var productRemoteRepository: ProductRemoteRepository,
    var mapper: Mapper
) : ViewModel() {


    fun getProductsOfSubCategory(statusMap: HashMap<String, String>): MutableLiveData<List<AllProductListItem>> {
        var productListOfSubCategory = MutableLiveData<List<AllProductListItem>>()

        viewModelScope.launch {
            when (val either = productRemoteRepository.getAllProductsOfSubCategory(statusMap)) {
                is Either.Right -> productListOfSubCategory.value =
                    mapper.mapToAllProductListItemList(either.b)
                is Either.Left -> ShopConstant.showError(either.a)
            }
        }

        return productListOfSubCategory
    }

}