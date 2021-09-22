package com.tradewin.lesson16room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tradewin.lesson16room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { DataAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
        setupRv()
        val list = RoomApp.DB?.getUserDao()?.getAllUsers()
        adapter.addAll(list)
    }

    private fun setupListeners() {
        binding.btnSave.setOnClickListener {
            RoomApp.DB?.getUserDao()?.saveUser(
                UserInfoModel(
                    name = binding.name.text.toString(),
                    secondName = binding.secondName.text.toString()
                )
            )
            val list = RoomApp.DB?.getUserDao()?.getAllUsers()
            adapter.addAll(list)
        }
    }

    private fun setupRv() {
        binding.recycler.adapter = adapter
    }
}