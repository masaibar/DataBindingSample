package com.masaibar.databindingsample

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.masaibar.databindingsample.databinding.ActivityUserListBinding
import com.masaibar.databindingsample.databinding.ListItemUserBinding

class UserListActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, UserListActivity::class.java))
        }
    }

    private val binding: ActivityUserListBinding by lazy {
        DataBindingUtil
                .setContentView<ActivityUserListBinding>(this, R.layout.activity_user_list)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        val userAdapter = UserAdapter(createUserList())
        binding.userRecycler.apply {
            adapter = userAdapter
        }
    }

    private fun createUserList(): List<User> {
        return ArrayList<User>().apply {
            add(User("Taro", "Yamada"))
            add(User("Satoru", "Satonaka"))
            add(User("Santaro", "Hohoemi"))
            add(User("Kazuto", "Tonoma"))
            add(User("Masami", "Iwaki"))
        }
    }

    class UserAdapter(
            private val users: List<User>
    ) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
            val binding = ListItemUserBinding
                    .inflate(LayoutInflater.from(parent?.context), parent, false)

            return ViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return users.size
        }

        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            val user = users[position]
            holder?.binding?.user = user
            holder?.binding?.executePendingBindings() //即時反映を行う
        }

        class ViewHolder(val binding: ListItemUserBinding) : RecyclerView.ViewHolder(binding.root)
    }
}
