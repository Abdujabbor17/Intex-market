package com.android.intex_market.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.intex_market.databinding.ItemCategoryBinding
import com.android.intex_market.model.CategoryModel
import com.android.intex_market.utils.CategoryInfo

class CategoryAdapter:ListAdapter<CategoryModel,CategoryAdapter.Vh>(MyDiffUtil()) {
    var itemClick: (() -> Unit)? = null

    inner  class Vh(var binding:ItemCategoryBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(category: CategoryModel){
            binding.nameCategory.text = category.categoryname

            binding.nameCategory.setOnClickListener {
                CategoryInfo.categoryname = category.categoryname
                CategoryInfo.id = category.id
                itemClick!!.invoke()
            }
        }
    }



    class MyDiffUtil : DiffUtil.ItemCallback<CategoryModel>() {
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {

        return Vh(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
       holder.bind(getItem(position))
    }


}