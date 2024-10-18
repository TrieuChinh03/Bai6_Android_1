package dnt.vip.bai6_android_1

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import dnt.vip.bai6_android_1.databinding.ActivityMainBinding
import dnt.vip.bai6_android_1.di.ExerciseApplication
import dnt.vip.bai6_android_1.ui.adapter.UserAdapter
import dnt.vip.bai6_android_1.viewmodel.UserViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter

    @Inject
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //---   Khởi tạo viewmodel  ---

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
        observations()
    }

    //===   Khởi tạo    ===
    private fun init() {
        //---   Cung cấp đối tượng UserViewModel   ---
        (application as ExerciseApplication).appComponent.inject(this)

        //---   Cấu hình RecyclerView   ---
        userAdapter = UserAdapter()
        binding.rccvUsers.layoutManager = LinearLayoutManager(this)
        binding.rccvUsers.adapter = userAdapter
        binding.pgbLoading.visibility = View.VISIBLE

        userViewModel.fetchUsers()  //-> Lấy danh sách user
    }

    //===   Các quan sát dữ liệu   ===
    private fun observations() {
        userViewModel.usersLiveData.observe(this) { users ->
            userAdapter.setData(users)
            binding.pgbLoading.visibility = View.GONE
        }
    }

}
