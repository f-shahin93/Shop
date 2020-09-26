package com.hamitest.shop.data.network

import com.hamitest.shop.data.model.category.Category
import com.hamitest.shop.data.model.customer.Customer
import com.hamitest.shop.data.model.order.Order
import com.hamitest.shop.data.model.product.Product
import com.hamitest.shop.data.model.review.Review
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("products/?")
    suspend fun getProductsList(@QueryMap productQueries: Map<String, String>): List<Product>

    @GET("products/{id}/?")
    suspend fun getProduct(
        @Path("id") productId: String,
        @QueryMap productQueries: Map<String, String>
    ): Product

    @GET("products/categories")
    suspend fun getCategories(
        @QueryMap productQueries: Map<String, String>,
        @Query("display") displayCategories: String,
        @Query("parent") parentCategories: String
    ): List<Category>

    @GET("products/categories")
    suspend fun getAllCategories(
        @QueryMap productQueries: Map<String, String>,
        @Query("per_page") per_page: String,
        @Query("page") pageNumber: String
    ): List<Category>

//    @GET("products/?")
//    suspend fun getProductsOFSubCategories(
//        @QueryMap productQueries: Map<String, String>,
//        @Query("category") categoryId: String,
//        @Query("name") name: String
//    ): List<Product>

    @GET("products/?")
    suspend fun getProductsOFSubCategories(
        @QueryMap productQueries: Map<String, String>
    ): List<Product>

    @GET("products/reviews")
    fun getProductReviewsList(
        @QueryMap productQueries: Map<String, String>
        , @Query("product") productId: String
    ): Call<List<Review>>

    @POST("customers")
    fun setCustomers(
        @QueryMap productQueries: Map<String, String>,
        @Body customer: Customer
    ): Call<Customer>

//    @FormUrlEncoded
//    @POST("customers")
//    Call<Customers> setCustomers(@QueryMap Map<String, String> productQueries,
//                                 @Field("email") String email,
//                                 @Field("first_name") String first_name,
//                                 @Field("last_name") String last_name,
//                                 @Field("username") String username);

    //    @FormUrlEncoded
    //    @POST("customers")
    //    Call<Customers> setCustomers(@QueryMap Map<String, String> productQueries,
    //                                 @Field("email") String email,
    //                                 @Field("first_name") String first_name,
    //                                 @Field("last_name") String last_name,
    //                                 @Field("username") String username);
    @GET("customers")
    fun getCustomer(@QueryMap productQueries: Map<String, String>): Call<List<Customer>>

    @POST("orders")
    fun setOrder(
        @QueryMap productQueries: Map<String, String>,
        @Body orders: Order
    ): Call<Order>
}