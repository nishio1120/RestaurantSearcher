package com.example.restaurantsearcher.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantsearcher.databinding.ItemRangeBinding

class RangeListViewHolder(private val binding: ItemRangeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    //rangeTextViewに値をバインド
    fun bind(range: String) {
        binding.range = range
    }
}