package com.tradewin.lesson16room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tradewin.lesson16room.databinding.ItemDataBinding

class DataAdapter : RecyclerView.Adapter<DataViewHolder>() {

    private val list = arrayListOf<UserInfoModel>()

    fun add(user: UserInfoModel) {
        list.add(user)
        notifyDataSetChanged()
    }

    fun addAll(users: List<UserInfoModel>?) {
        if (users != null) {
            list.clear()
            list.addAll(users)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}


class DataViewHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(userInfoModel: UserInfoModel) {
        binding.tvName.text = userInfoModel.name
        binding.tvSecondName.text = userInfoModel.secondName
    }
}