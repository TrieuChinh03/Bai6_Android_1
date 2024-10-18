package dnt.vip.bai6_android_1.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dnt.vip.bai6_android_1.R
import dnt.vip.bai6_android_1.data.model.User
import dnt.vip.bai6_android_1.databinding.ItemUserBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList: List<User> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(users: List<User>) {
        userList = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
        holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.context, R.anim.slide_up_scale))
    }

    override fun getItemCount(): Int = userList.size


    class UserViewHolder(private val binding: ItemUserBinding)
        : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            Glide.with(binding.root)
                .load(user.picture.large)
                .transform(CenterCrop(), RoundedCorners(25))
                .into(binding.imgAvt)

            binding.tvEmail.text = "Email: ${user.email}"
            binding.tvName.text = "Name: ${user.name.first} ${user.name.last}"
            binding.tvPhone.text = "Phone: ${user.phone}"
        }
    }
}
