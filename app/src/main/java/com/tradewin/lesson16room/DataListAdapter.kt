package com.tradewin.lesson16room

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.tradewin.lesson16room.databinding.ItemDataBinding

class DataListAdapter(private val listener: UserListener) : ListAdapter<UserInfoModel, DataViewHolder>(USER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<UserInfoModel>() {

            override fun areItemsTheSame(oldItem: UserInfoModel, newItem: UserInfoModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: UserInfoModel,
                newItem: UserInfoModel
            ): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.name == newItem.name &&
                        oldItem.secondName == newItem.secondName

            }
        }
    }
}