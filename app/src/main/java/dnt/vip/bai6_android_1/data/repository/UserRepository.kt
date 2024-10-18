package dnt.vip.bai6_android_1.data.repository

import dnt.vip.bai6_android_1.data.model.User
import dnt.vip.bai6_android_1.data.remote.api.ApiUser
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiUser
) {
    //===   Lấy danh sách người dùng    ===
    suspend fun getUsers(): List<User>? {
        val response = apiService.getUsers(30)
        return if (response.isSuccessful) {
            response.body()?.results
        } else {
            null
        }
    }
}
