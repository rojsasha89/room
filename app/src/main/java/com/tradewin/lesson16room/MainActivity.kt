package com.tradewin.lesson16room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tradewin.lesson16room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UserListener {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { DataListAdapter(this) }
    private var userEdited: UserInfoModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
        setupRv()

        RoomApp.DB?.getUserDao()?.getAllUsersObserve()?.observe(this, {
            adapter.submitList(it)
        })
    }

    private fun setupListeners() {
        binding.btnSave.setOnClickListener {
            RoomApp.DB?.getUserDao()?.saveUser(
                UserInfoModel(
                    name = binding.name.text.toString(),
                    secondName = binding.secondName.text.toString()
                )
            )
        }

        binding.btnUpdate.setOnClickListener {
            userEdited?.name = binding.name.text.toString()
            userEdited?.secondName = binding.secondName.text.toString()
            RoomApp.DB?.getUserDao()?.updateUser(userEdited)
        }
    }

    private fun setupRv() {
        binding.recycler.adapter = adapter
    }

    override fun deleteItem(user: UserInfoModel) {
        RoomApp.DB?.getUserDao()?.deleteUser(user)
    }

    override fun updateItem(user: UserInfoModel) {
        binding.name.setText(user.name)
        binding.secondName.setText(user.secondName)
        userEdited = UserInfoModel(
            id = user.id,
            name = user.name,
            secondName = user.secondName
        )
    }

    override fun openDetails(user: UserInfoModel) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.ID, user.id)
        startActivity(intent)
    }
}