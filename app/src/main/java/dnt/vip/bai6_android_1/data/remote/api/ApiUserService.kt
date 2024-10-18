package dnt.vip.bai6_android_1.data.remote.api

import dnt.vip.bai6_android_1.data.model.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiUser {
    @GET("api/")
    suspend fun getUsers(@Query("results") results: Int)
    : Response<UsersResponse>
}
