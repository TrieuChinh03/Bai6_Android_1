package dnt.vip.bai6_android_1.data.repository

import dnt.vip.bai6_android_1.data.model.User
import dnt.vip.bai6_android_1.data.remote.network.ApiClient

class UserRepository {
    private val apiService = ApiClient.getApiService()

    //===   Lấy danh sách người dùng    ===
    suspend fun getUsers(): List<User>? {
        val response = apiService.getUsers()
        return if (response.isSuccessful) {
            response.body()?.results
        } else {
            null
        }
    }
}
