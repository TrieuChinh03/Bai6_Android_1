package dnt.vip.bai6_android_1

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import dnt.vip.bai6_android_1.databinding.ActivityMainBinding
import dnt.vip.bai6_android_1.ui.adapter.UserAdapter
import dnt.vip.bai6_android_1.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
        observations()
    }

    //===   Quan sát dữ liệu    ===
    private fun observations() {
        userViewModel.usersLiveData.observe(this) { users ->
            userAdapter.setData(users)
            binding.pgbLoading.visibility = View.GONE
        }
    }

    //===   Khởi tạo    ===
    private fun init() {
        userAdapter = UserAdapter()
        binding.rccvUsers.layoutManager = LinearLayoutManager(this)
        binding.rccvUsers.adapter = userAdapter
        binding.pgbLoading.visibility = View.VISIBLE
        userViewModel.fetchUsers()
    }
}
