package dnt.vip.bai6_android_1.data.remote.service

import dnt.vip.bai6_android_1.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiUserService {
    @GET("?results=20")
    suspend fun getUsers(): Response<ApiResponse>
}
