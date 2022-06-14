package com.android.intex_market.adapter.admin

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.intex_market.R
import com.android.intex_market.databinding.ItemConsultingListBinding
import com.android.intex_market.model.ConsultingModel

class ConsultingListAdapter : ListAdapter<ConsultingModel, ConsultingListAdapter.Vh>(MyDiffUtil()) {
    var bAcceptClick: (() -> Unit)? = null
    var bDeleteClick: (() -> Unit)? = null


    inner class Vh(var binding: ItemConsultingListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(consult: ConsultingModel) {

            binding.apply {
                name.text = "Name: " + consult.name
                phone.text = "Phone: " + consult.phone
                time.text = "Time: " + consult.date

                if (consult.active) {
                    bAccept.setBackgroundColor(R.drawable.button_bg_unaccepted)
                } else {
                    bAccept.setBackgroundColor(R.drawable.button_bg_accepted)
                }

                bAccept.setOnClickListener {
                    bAcceptClick!!.invoke()
                    if (consult.active) {
                        bAccept.setBackgroundColor(R.drawable.button_bg_accepted)
                    } else {
                        bAccept.setBackgroundColor(R.drawable.button_bg_unaccepted)
                    }
                }

                 bDelete.setOnClickListener {
                    bDeleteClick!!.invoke()
                }


            }
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<ConsultingModel>() {
        override fun areItemsTheSame(oldItem: ConsultingModel, newItem: ConsultingModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ConsultingModel, newItem: ConsultingModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemConsultingListBinding.inflate(
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