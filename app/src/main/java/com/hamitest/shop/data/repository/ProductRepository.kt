package com.hamitest.shop.data.repository

import arrow.core.Either
import com.hamitest.shop.data.mapper.ErrorMapper
import com.hamitest.shop.data.mapper.HttpErrorMapper
import com.hamitest.shop.data.model.Error
import com.hamitest.shop.data.model.category.Category
import com.hamitest.shop.data.model.product.Product
import com.hamitest.shop.data.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val apiService: ApiService,
    errorMapper: ErrorMapper = ErrorMapper(HttpErrorMapper())
) : BaseRepository(errorMapper) {

//    companion object {
//        private val repository: ProductRepository by lazy { ProductRepository() }
//
//        fun getInstance(): ProductRepository {
//            return repository
//        }
//    }

    var cachedCategories: List<Category>? = null
    private var mQueries = hashMapOf(
        "consumer_key" to "ck_0c3f701d165bef89c42a0a5ef6c8388df5179c31",
        "consumer_secret" to "cs_a0dbb7a91a42aec74c91d1ff7612f7559475bd28"
    )

    suspend fun getCategory(displayCatg: String, parentCatg: Int): Either<Error, List<Category>> {
        return safeApiCall {
            apiService.getCategories(
                mQueries,
                displayCatg,
                parentCatg.toString()
            )
        }
    }

    suspend fun getAllCategory(): Either<Error, List<Category>> {
         return safeApiCall {
            val allCategories = mutableListOf<Category>()
            cachedCategories?.let { return@safeApiCall it }
            var continueFlag = true
            val perPage = 10
            var pageNumber = 1
            while (continueFlag) {
                val categories = apiService.getAllCategories(
                    mQueries,
                    perPage.toString(),
                    pageNumber.toString()
                )
                allCategories.addAll(categories)
                if (categories.size == perPage) {
                    pageNumber++
                } else {
                    continueFlag = false
                }
            }
            cachedCategories = allCategories
            return@safeApiCall allCategories
        }
    }

    suspend fun getProducts(status: String): Either<Error, List<Product>> {
        var queries = HashMap<String, String>()
        queries.putAll(mQueries)
        queries.put("orderby", status);
        return safeApiCall { apiService.getProductsList(queries) }
    }

    suspend fun getProduct(productId: Int): Either<Error, Product> {
        return safeApiCall { apiService.getProduct(productId.toString(), mQueries) }
    }

    suspend fun getAllProductsOfSubCategory(
        statusMap: HashMap<String, String>
    ): Either<Error, List<Product>> {
        var query = HashMap<String, String>()
        query.putAll(mQueries)
        query.putAll(statusMap)

        return safeApiCall {
            apiService.getProductsOFSubCategories(query)
        }

    }

}