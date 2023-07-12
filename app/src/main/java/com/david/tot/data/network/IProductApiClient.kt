package com.david.tot.data.network

import com.david.tot.domain.model.Product
import com.david.tot.domain.model.ProductResponse
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
//import retrofit2.Retrofit

interface IProductApiClient {
    //@GET("2168bffa-9889-4a01-869c-32f62026a19f")
    //@GET("8fa604ab-186b-4648-ad1b-6b204294314d")
    @GET("department")
    suspend fun getAllRecipes(): Response<ProductResponse>

    @POST("products")
    suspend fun addProduct(@Body product: Product): Response<ResponseBody>

    @PUT("products/{id}")
    suspend fun updateProduct(@Path("id") id:String, @Body product:Product): Response<ResponseBody>

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") id:Int): Response<ResponseBody>

    @Multipart
    @POST("pictures")
    suspend fun uploadPicture(@Part part: MultipartBody.Part,@Part("id_product") id_product:Int): Response<ResponseBody>
}

