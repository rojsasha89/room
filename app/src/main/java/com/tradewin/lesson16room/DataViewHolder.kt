package com.tradewin.lesson16room

import androidx.recyclerview.widget.RecyclerView
import com.tradewin.lesson16room.databinding.ItemDataBinding

class DataViewHolder(private val binding: ItemDataBinding, private val listener: UserListener) :
    RecyclerView.ViewHolder(binding.root) {

    init {

    }

    fun bind(userInfoModel: UserInfoModel) {
        binding.tvName.text = userInfoModel.name
        binding.tvSecondName.text = userInfoModel.secondName

        binding.imgDelete.setOnClickListener {
            listener.deleteItem(userInfoModel)
        }
        binding.imgEdit.setOnClickListener {
            listener.updateItem(userInfoModel)
        }
        binding.root.setOnClickListener {
            listener.openDetails(userInfoModel)
        }
    }
}