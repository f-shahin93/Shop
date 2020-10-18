package com.hamitest.shop.presenter.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.hamitest.shop.data.mapper.Mapper
import com.hamitest.shop.data.repository.ProductRemoteRepository
import com.hamitest.shop.presenter.utils.ShopConstant
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    private val productRemoteRepository: ProductRemoteRepository,
    private val mapper: Mapper
) : ViewModel() {

    var mParentCategoriesListLiveData: MutableLiveData<List<ParentCategoryItem>> = MutableLiveData()
    val mListNewestProMutableLiveData: MutableLiveData<List<ProductItem>> = MutableLiveData()
    val mListPopularProMutableLiveData: MutableLiveData<List<ProductItem>> = MutableLiveData()
    val mListMostPointProMutableLiveData: MutableLiveData<List<ProductItem>> = MutableLiveData()


    init {
        getAllProducts()
    }


    private fun getAllProducts() {
        viewModelScope.launch {

            launch {
                when (val either = productRemoteRepository.getCategory("default", 0)) {
                    is Either.Right -> mParentCategoriesListLiveData.value =
                        mapper.mapToCategoryItemList(either.b)
                    is Either.Left -> ShopConstant.showError(either.a)
                }
            }

            launch {
                when (val either = productRemoteRepository.getProducts("date")) {
                    is Either.Right -> mListNewestProMutableLiveData.value =
                        mapper.mapToProductItemList(either.b)
                    is Either.Left -> ShopConstant.showError(either.a)
                }
            }

            launch {
                when (val either = productRemoteRepository.getProducts("popularity")) {
                    is Either.Right -> mListPopularProMutableLiveData.value =
                        mapper.mapToProductItemList(either.b)
                    is Either.Left -> ShopConstant.showError(either.a)
                }
            }

            launch {
                when (val either = productRemoteRepository.getProducts("rating")) {
                    is Either.Right -> mListMostPointProMutableLiveData.value =
                        mapper.mapToProductItemList(either.b)
                    is Either.Left -> ShopConstant.showError(either.a)
                }
            }

        }

    }

    fun getAllCategories() {
        viewModelScope.launch {
            productRemoteRepository.getAllCategory()
        }
    }


    fun getListNewestProMutableLiveData(): MutableLiveData<List<ProductItem>> {
        return mListNewestProMutableLiveData
    }

    fun getListPopularProMutableLiveData(): MutableLiveData<List<ProductItem>> {
        return mListPopularProMutableLiveData
    }

    fun getListMostPointProMutableLiveData(): MutableLiveData<List<ProductItem>> {
        return mListMostPointProMutableLiveData
    }

    fun getListCategoryMutableLiveData(): MutableLiveData<List<ParentCategoryItem>> {
        return mParentCategoriesListLiveData
    }

    /*  fun getListNewestProByPageMutableLiveData(
          status: String?,
          pageNumber: Int
      ): MutableLiveData<List<Product?>?>? {
          val mLisProMutableLiveData: MutableLiveData<List<Product?>?>
          mLisProMutableLiveData = mShopFetcher.getOrderProductListByPage(status, pageNumber)
          return mLisProMutableLiveData
      }

      fun getListPopularProByPageMutableLiveData(
          status: String?,
          pageNumber: Int
      ): MutableLiveData<List<Product?>?>? {
          val mLisProMutableLiveData: MutableLiveData<List<Product?>?>
          mLisProMutableLiveData = mShopFetcher.getOrderProductListByPage(status, pageNumber)
          return mLisProMutableLiveData
      }

      fun getListMostPointProByPageMutableLiveData(
          status: String?,
          pageNumber: Int
      ): MutableLiveData<List<Product?>?>? {
          val mLisProMutableLiveData: MutableLiveData<List<Product?>?>
          mLisProMutableLiveData = mShopFetcher.getOrderProductListByPage(status, pageNumber)
          return mLisProMutableLiveData
      }*/


}