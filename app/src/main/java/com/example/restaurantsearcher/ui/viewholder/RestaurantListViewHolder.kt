package com.example.restaurantsearcher.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantsearcher.databinding.ItemResultBinding
import com.example.restaurantsearcher.data.HotPepperData

class RestaurantListViewHolder(
    private val binding: ItemResultBinding,
    private val onRestaurantItemClick: (HotPepperData) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: HotPepperData) {
        binding.restaurant = item
        binding.root.setOnClickListener {
            onRestaurantItemClick(item)
        }
    }

    fun unbind() {
        binding.restaurant = null
        binding.icon.setImageDrawable(null)
    }
}