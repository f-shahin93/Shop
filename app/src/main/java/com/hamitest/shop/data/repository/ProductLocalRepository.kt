package com.hamitest.shop.data.repository

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hamitest.shop.data.network.ApiService
import io.realm.Realm
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ProductLocalRepository @Inject constructor(
    private var apiService: ApiService,
    private var context: Context,
    private var productRemoteRepository: ProductRemoteRepository
) {

   // private var productListLiveData: MutableLiveData<List<ProductEntity>>? = MutableLiveData()
    private var totalPriceOfCartProductsLiveData: MutableLiveData<Double> = MutableLiveData();
    private var totalCountProductsCartLiveData: MutableLiveData<Int> = MutableLiveData();
    private var realm = Realm.getDefaultConfiguration()

    init {
        //realm = Realm.getDefaultInstance()
    }

    fun setProductsListShoppingCart() {
        val productIdList: MutableList<Int> = ArrayList()
//        for (shoppingCart in realm.where(ShoppingCartEntity::class.java).findAll()) {
//            productIdList.add(shoppingCart.getIdProduct())
//        }
        //GetProductListAsyncTask().execute(productIdList)
    }

   /* fun addProductToList(product: ProductEntity) {
        realm.beginTransaction()
        if (!addCountProductFromCart(product)) {
            val shoppingCart: ShoppingCartEntity =
                realm.createObject(ShoppingCartEntity::class.java, product.id.toString())
            shoppingCart.idProduct = product.id
            shoppingCart.countProduct = 1
        }
        if (realm.isInTransaction())
            realm.commitTransaction()

        totalCountProductsCartLiveData.value =
            realm.where(ShoppingCartEntity::class.java).findAll().size()

        totalPriceOfCartProductsLiveData.value = calculateTotalPriceProductsCart()
    }*/


  /*  private fun addCountProductFromCart(product: ProductEntity): Boolean {
        if (!realm.isInTransaction())
            realm.beginTransaction()
        for (shoppingCart in realm.where(ShoppingCartEntity::class.java).findAll()) {
            if (shoppingCart.IdProduct === product.id) {
                if (shoppingCart.getCountProduct() >= 10)
                    return true
                shoppingCart.setCountProduct(shoppingCart.getCountProduct() + 1)

                val changeProductList : List<ProductEntity> = productListLiveData.value!!
                for (changedproduct in changeProductList) {
                    if (changedproduct.id == product.id) {
                        if (changedproduct.countProductInCart.value != null)
                            changedproduct.countProductInCart.value =
                                changedproduct.countProductInCart.value!! + 1
                        else
                            changedproduct.countProductInCart.setValue(1)
                    }
                }
                productListLiveData.setValue(changeProductList)
                realm.commitTransaction()
                return true
            }
        }
        return false
    }*/

   /* private fun calculateTotalPriceProductsCart(): Double? {
        var numberTotal = 0.0
        if (productListLiveData?.value != null)
            for (product in productListLiveData?.value!!) {
            if (product.countProductInCart.value != null) {
                if (product.regularPrice == "")
                    numberTotal += product.countProductInCart.value!! * (product.price.toDouble())
                else
                    numberTotal += product.countProductInCart.value!! * product.regularPrice.toDouble()
            }
        }
        return numberTotal
    }*/

    /*fun deletePruductFromListCart(product: ProductEntity) {
        if (!realm.isInTransaction())
            realm.beginTransaction()

        for (shoppingCart in realm.where(ShoppingCartEntity::class.java).findAll()) {
            if (shoppingCart.IdProduct === product.id) {
                shoppingCart.deleteFromRealm()

                val changeProductList: MutableList<ProductEntity> = productListLiveData.value!!
                for (changeProduct in changeProductList) {
                    if (changeProduct.id == product.id) {
                        changeProductList.remove(changeProduct)
                        break
                    }
                }
                productListLiveData?.value = (changeProductList)
                break
            }
        }
        totalPriceOfCartProductsLiveData.setValue(calculateTotalPriceProductsCart())
        totalCountProductsCartLiveData.value = realm.where(ShoppingCartEntity::class.java).findAll().size()

        realm.commitTransaction()
    }*/

    /*fun changingNumOfProductFromCart(product: ProductEntity, countOfProduct: Int) {
        if (!realm.isInTransaction())
            realm.beginTransaction()

        for (shoppingCart in realm.where(ShoppingCartEntity::class.java).findAll()) {
            if (shoppingCart.IdProduct === product.id) {
                shoppingCart.setCountProduct(countOfProduct)

                val changeProductList: List<ProductEntity> = productListLiveData?.value!!
                for (changeProduct in changeProductList) {
                    if (changeProduct.id == product.id) {
                        changeProduct.countProductInCart.value = (countOfProduct)
                        break
                    }
                }
                productListLiveData?.setValue(changeProductList)
                break
            }
        }
        realm.commitTransaction()
        totalPriceOfCartProductsLiveData.setValue(calculateTotalPriceProductsCart())
    }*/

    fun getCountCartFromDB() {
//        totalCountProductsCartLiveData.setValue(
//            realm.where(ShoppingCartEntity::class.java).findAll().size()
//        )
    }

    /*internal class GetProductListAsyncTask :
        AsyncTask<List<Int?>?, Void?, Void?>() {
        protected override fun doInBackground(vararg lists: List<Int?>): Void? {
            mShopFetcher.getProducstListByIdProduct(lists[0])
            return null
        }

        override fun onPostExecute(aVoid: Void?) {
            super.onPostExecute(aVoid)
            Log.d("TagProduct", "on post execute")
            val productList: MutableList<ProductEntity> = ArrayList()
            for (product in mShopFetcher.getProductListShoppingCart()) {
                for (shoppingCart in realm.where(ShoppingCartEntity::class.java)
                    .findAll()) {
                    if (shoppingCart.getIdProduct() === product.id) {
                        product.getCountProductInCart().postValue(shoppingCart.getCountProduct())
                        productList.add(product)
                        break
                    }
                }
            }
            productListLiveData.postValue(productList)
            totalCountProductsCartLiveData.postValue(
                realm.where(ShoppingCartEntity::class.java).findAll().size()
            )
            totalPriceOfCartProductsLiveData.postValue(calculateTotalPriceProductsCart())
        }
    }*/




}


/*       class GetProductListAsyncTask extends AsyncTask<List<Integer>, Void, Void> {

        @Override
        protected Void doInBackground(List<Integer>... lists) {
            mShopFetcher.getProducstListByIdProduct(lists[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d("TagProduct", "on post execute");
            List<Product> productList = new ArrayList<>();

            for (Product product : mShopFetcher.getProductListShoppingCart()) {
                for (ShoppingCart shoppingCart : mRealm.where(ShoppingCart.class).findAll()) {
                    if (shoppingCart.getIdProduct() == product.getId()) {
                        product.getCountProductInCart().postValue(shoppingCart.getCountProduct());
                        productList.add(product);
                        break;
                    }
                }
            }

            mProductListLiveData.postValue(productList);
            mTotalCountProductsCartLiveData.postValue(mRealm.where(ShoppingCart.class).findAll().size());
            mTotalPriceOfCartProductsLiveData.postValue(calculateTotalPriceProductsCart());
        }
    }
 */