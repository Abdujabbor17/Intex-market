package com.android.intex_market.adapter.admin

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.intex_market.R
import com.android.intex_market.databinding.ItemAdminProductBinding
import com.android.intex_market.model.ProductModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class AdminProductAdapter :
    ListAdapter<ProductModel, AdminProductAdapter.ProductVh>(MyDiffUtil()) {
    var moreClick: (() -> Unit)? = null



    inner class ProductVh(var binding: ItemAdminProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(product: ProductModel) {

            binding.apply {
                oldPrice.text = "Old price:  " + product.old_price
                newPrice.text = "New price:  " + product.dis_price
                depth.text = "Depth:  " + product.razmer_sm
                shape.text = "Shape:  " + product.ramka_ru
                size.text = "Size:  " + product.razmer_m

                Glide.with(root.context)
                    .load(product.image)
                    .error(R.drawable.intex)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(imgProduct)

                moreIv.setOnClickListener {
                    moreClick!!.invoke()
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
            ItemAdminProductBinding.inflate(
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