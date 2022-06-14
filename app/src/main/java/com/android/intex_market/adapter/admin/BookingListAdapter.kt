package com.android.intex_market.adapter.admin

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.intex_market.R
import com.android.intex_market.databinding.ItemBookingListBinding
import com.android.intex_market.model.BookingModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class BookingListAdapter : ListAdapter<BookingModel, BookingListAdapter.Vh>(MyDiffUtil()) {
    var bAcceptClick: (() -> Unit)? = null
    var bDeleteClick: (() -> Unit)? = null


    inner class Vh(var binding: ItemBookingListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(order: BookingModel) {

            binding.apply {
                name.text = "Name: " + order.name
                address.text = "Address: " + order.address
                price?.text = "Price: " + order.money
                phone.text = "Phone: " + order.phone
                size.text = "Size: " + order.pool_frame
                time.text = "Time: " + order.date

                if (order.active) {
                    bAccept?.setBackgroundColor(R.drawable.button_bg_unaccepted)
                } else {
                    bAccept?.setBackgroundColor(R.drawable.button_bg_accepted)
                }

                bAccept?.setOnClickListener {
                    bAcceptClick!!.invoke()
                    if (order.active) {
                        bAccept.setBackgroundColor(R.drawable.button_bg_accepted)
                    } else {
                        bAccept.setBackgroundColor(R.drawable.button_bg_unaccepted)
                    }
                }

                 bDelete.setOnClickListener {
                    bDeleteClick!!.invoke()
                }

                Glide.with(root.context)
                    .load(order.image)
                    .error(R.drawable.intex)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(imgProduct)

            }
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<BookingModel>() {
        override fun areItemsTheSame(oldItem: BookingModel, newItem: BookingModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BookingModel, newItem: BookingModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemBookingListBinding.inflate(
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