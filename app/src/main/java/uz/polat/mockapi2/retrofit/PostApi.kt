package uz.polat.mockapi2.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("posts/1")
    suspend fun getPost1(): Response<Post>

    @GET("posts/2")
    suspend fun getPost2(): Response<Post>

    @GET("posts/3")
    suspend fun getPost3(): Response<Post>

}