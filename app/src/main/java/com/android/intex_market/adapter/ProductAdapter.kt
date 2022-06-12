package com.android.intex_market.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.intex_market.R
import com.android.intex_market.databinding.ItemCategoryBinding
import com.android.intex_market.databinding.ItemProductBinding
import com.android.intex_market.model.ProductModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ProductAdapter : ListAdapter<ProductModel, ProductAdapter.ProductVh>(MyDiffUtil()) {
    var bookClick: (() -> Unit)? = null

    inner class ProductVh(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(product: ProductModel) {

            binding.apply {
                recommendTv.text = product.recommendation_ru
                oldCostTv.text = product.old_price + " сум"
                newCostTv.text = product.dis_price + " сум"
                Glide.with(root.context)
                    .load(product.image)
                    .error(R.drawable.intex)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(imgProduct)


                bookBtn.setOnClickListener {
                    bookClick!!.invoke()
                }
            }
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<ProductModel>() {
        override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem == newItem
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVh {

        return ProductVh(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }




    override fun onBindViewHolder(holder: ProductVh, position: Int) {
        holder.bind(getItem(position))
    }


}