package com.example.restaurantsearcher.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.restaurantsearcher.databinding.ItemRangeBinding
import com.example.restaurantsearcher.viewholder.RangeListViewHolder

//検索距離のデータの管理を行う
class RangeListAdapter(private val listener: OnRangeItemClickListener) :
    ListAdapter<String, RangeListViewHolder>(rangeListDiffCallback) {
    private companion object {

        private val rangeListDiffCallback = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(
                oldText: String,
                newText: String
            ): Boolean = oldText == newText

            override fun areContentsTheSame(
                oldText: String,
                newText: String
            ): Boolean = oldText == newText
        }
    }

    interface OnRangeItemClickListener {
        fun onRangeItemClick(range: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RangeListViewHolder {
        val view = ItemRangeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RangeListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RangeListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onRangeItemClick(position + 1)
        }
    }
}