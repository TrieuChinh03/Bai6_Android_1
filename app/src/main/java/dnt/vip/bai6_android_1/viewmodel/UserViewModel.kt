package dnt.vip.bai6_android_1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dnt.vip.bai6_android_1.data.model.User
import dnt.vip.bai6_android_1.data.repository.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val usersLiveData: MutableLiveData<List<User>> = MutableLiveData()

    //===   Lấy danh sách người dùng    ===
    fun fetchUsers() {
        viewModelScope.launch {
            userRepository.getUsers()?.let {
                usersLiveData.postValue(it)
            }
        }
    }
}
