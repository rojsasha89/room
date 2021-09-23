package com.tradewin.lesson16room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tradewin.lesson16room.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userID = intent.getIntExtra(ID, -1)
        val user = RoomApp.DB?.getUserDao()?.getUser(userID)

        binding.tvId.text = user?.id.toString()
        binding.tvName.text = user?.name
        binding.tvSecondName.text = user?.secondName
    }


    companion object {
        const val ID = "ID"
    }
}