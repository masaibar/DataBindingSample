package com.masaibar.databindingsample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.masaibar.databindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.user = User("Makoto", "Saibara")

        setupShowNameButton()
        setupOpenUserListButton()
    }

    private fun setupShowNameButton() {
        binding.buttonShowName.setOnClickListener {
            Toast.makeText(
                    this,
                    "My name is ${binding.user?.firstName}, ${binding.user?.lastName}.",
                    Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupOpenUserListButton() {
        binding.buttonUserList.setOnClickListener {
            UserListActivity.start(this)
        }
    }
}
