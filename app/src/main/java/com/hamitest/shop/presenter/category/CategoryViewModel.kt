package com.hamitest.shop.presenter.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.hamitest.shop.data.mapper.Mapper
import com.hamitest.shop.data.repository.ProductRemoteRepository
import com.hamitest.shop.presenter.utils.ShopConstant
import com.hamitest.shop.presenter.home.ParentCategoryItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val productRemoteRepository: ProductRemoteRepository,
    var mapper: Mapper
) : ViewModel() {


    fun getParentCategories(): MutableLiveData<List<ParentCategoryItem>> {
        val parentCategoriesList = ArrayList<ParentCategoryItem>()
        val parentCategoriesListLiveData = MutableLiveData<List<ParentCategoryItem>>()

        viewModelScope.launch {
            when (val either = productRemoteRepository.getAllCategory()) {
                is Either.Right -> {
                    for (i in either.b) {
                        if (i.parent.equals(0)) {
                            parentCategoriesList.add(mapper.mapToCategoryHomeEntity(i))
                        }
                    }
                    parentCategoriesListLiveData.value = parentCategoriesList
                }
                is Either.Left -> ShopConstant.showError(either.a)
            }

        }
        return parentCategoriesListLiveData
    }

    fun getSubCategory(idParent: Int): MutableLiveData<List<SubCategoryItem>> {
        var subCategoriesList = ArrayList<SubCategoryItem>()
        var subCategoriesListLiveData = MutableLiveData<List<SubCategoryItem>>()

        viewModelScope.launch {
            when (val either = productRemoteRepository.getAllCategory()) {
                is Either.Right -> {
                    for (i in either.b) {
                        if (i.parent.equals(idParent)) {
                            subCategoriesList.add(mapper.mapToCategoryPageEntity(i))
                        }
                    }
                    subCategoriesListLiveData.value = subCategoriesList
                }

                is Either.Left -> ShopConstant.showError(either.a)
            }
        }
        return subCategoriesListLiveData
    }

}