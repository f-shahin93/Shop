package com.hamitest.shop.presenter.detailproduct

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.hamitest.shop.data.model.product.Product
import com.hamitest.shop.data.repository.ProductRemoteRepository
import com.hamitest.shop.presenter.utils.ShopConstant
import kotlinx.coroutines.launch
import javax.inject.Inject


class DetailProductViewModel @Inject constructor(
    private val productRemoteRepository: ProductRemoteRepository
) : ViewModel() {

    val productMutableLiveData: MutableLiveData<Product> = MutableLiveData()
    private val mIsClickAddtoCartLiveData = MutableLiveData<Boolean>()
    private val mIsClickDeleteItemLiveData = MutableLiveData<Boolean>()
    private val mIsChangingItemCartLiveData = MutableLiveData<Boolean>()
    lateinit var mProduct: Product
    //  private val mDelProduct: ProductItem? = null


    init {

    }

    fun getProductLiveData(productId: Int): MutableLiveData<Product> {
        viewModelScope.launch {
            when (val either = productRemoteRepository.getProduct(productId)) {
                is Either.Right -> productMutableLiveData.value = either.b
                is Either.Left -> ShopConstant.showError(either.a)
            }
        }
        return productMutableLiveData
    }

    /*  fun getProductReviewsListLiveData(productId: Int): MutableLiveData<List<Review>> {
          mShopFetcher.getProductReviewsList(productId.toString())
          return mShopFetcher.getProductReviewsListMLiveData()
      }

      fun addProduct(product: ProductItem?) {
          mProductRepository.addPruductToList(product)
      }

      fun getIsClickAddtoCartLiveData(): MutableLiveData<Boolean>? {
          return mIsClickAddtoCartLiveData
      }

      fun getIsChangingItemCartLiveData(): MutableLiveData<Boolean>? {
          return mIsChangingItemCartLiveData
      }

      fun getIsClickDeleteItemLiveData(): MutableLiveData<Boolean>? {
          return mIsClickDeleteItemLiveData
      }

      fun getListShoppingCart(): MutableLiveData<List<ProductItem?>?>? {
          return mProductRepository.getProductListLiveData()
      }

      fun setProductListRepo() {
          mProductRepository.setProductsListShoppingCart()
      }

      fun getTotalPrice(): MutableLiveData<Double?>? {
          return mProductRepository.getTotalPriceOfCartProductsLiveData()
      }

      fun getCountProductCart(): MutableLiveData<Int?>? {
          return mProductRepository.getTotalCountProductsCartLiveData()
      }

      fun initCountCart() {
          mProductRepository.getCountCartFromDB()
      }

      fun showDeleteDialog(
          product: ProductItem?,
          isDelete: Boolean
      ): MutableLiveData<Boolean>? {
          if (isDelete) {
              mIsClickDeleteItemLiveData.setValue(true)
              mProductRepository.deletePruductFromListCart(product)
          } else mIsClickDeleteItemLiveData.setValue(false)
          return mIsClickDeleteItemLiveData
      }

      fun changeCountProductListCart(product: ProductItem?, countOfProduct: Int) {
          mProductRepository.changingNumOfProductFromCart(product, countOfProduct)
          mIsChangingItemCartLiveData.value = true
      }

      fun postOrders(productList: List<ProductItem>): MutableLiveData<Boolean>? {
          return if (QueryPreferences.getStatusLogin(mContext)) {
              val user: User = mUserRepository.getUser()
              val lineItemsItems: MutableList<LineItemsItem> = ArrayList()
              val billing = Billing()
              val shipping = Shipping()
              for (product in productList) {
                  val line = LineItemsItem()
                  line.setQuantity(product.getCountProductInCart().getValue())
                  line.setProductId(product.getId())
                  lineItemsItems.add(line)
              }
              billing.setEmail(user.getEmail())
              billing.setFirstName(user.getFirstName())
              billing.setLastName(user.getLastName())
              shipping.setFirstName(user.getFirstName())
              shipping.setLastName(user.getLastName())
              val order = Orders(lineItemsItems, billing, shipping, user.getIdUser())
              mShopFetcher.setOrders(order)
          } else {
              val isPostLD = MutableLiveData<Boolean>()
              isPostLD.setValue(false)
              isPostLD
          }
      }*/

}