package com.eslam.goldkreaz.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eslam.entity.entities.CategoryEntity
import com.eslam.goldkreaz.R
import com.eslam.goldkreaz.databinding.CategoryRowItemBinding

class CategoryAdapter(private val listener: ClickListener) :
    ListAdapter<CategoryEntity, CategoryAdapter.ViewHolder>(DiffCall) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    companion object DiffCall : DiffUtil.ItemCallback<CategoryEntity>() {
        override fun areItemsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CategoryEntity, newItem: CategoryEntity): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(private val binding: CategoryRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    DataBindingUtil
                        .inflate(
                            LayoutInflater.from(parent.context),
                            R.layout.category_row_item,
                            parent, false
                        )
                )
            }
        }

        fun bind(category: CategoryEntity, listener: ClickListener) {
            binding.category = category
            binding.listener = listener
            binding.executePendingBindings()
        }
    }

    interface ClickListener {
        fun onRowClick(v: View, category: CategoryEntity)
    }
}