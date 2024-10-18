package dnt.vip.bai6_android_1.data.remote.network

import dnt.vip.bai6_android_1.data.remote.service.ApiUserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://randomuser.me/api/"

    fun getApiService(): ApiUserService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiUserService::class.java)
    }
}
