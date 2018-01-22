package com.masaibar.databindingsample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.masaibar.databindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.user = User("Makoto", "Saibara")
    }
}
