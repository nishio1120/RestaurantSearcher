package com.example.restaurantsearcher.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.restaurantsearcher.databinding.ItemResultBinding
import com.example.restaurantsearcher.data.HotPepperData
import com.example.restaurantsearcher.ui.viewholder.RestaurantListViewHolder

class RestaurantListAdapter(private val onRestaurantItemClick: (HotPepperData) -> Unit) :
    ListAdapter<HotPepperData, RestaurantListViewHolder>(restaurantDataDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListViewHolder {
        val view = ItemResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RestaurantListViewHolder(view, onRestaurantItemClick)
    }

    override fun onBindViewHolder(holder: RestaurantListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onViewRecycled(holder: RestaurantListViewHolder) {
        holder.unbind()
    }

    private companion object {
        private val restaurantDataDiffCallback = object : DiffUtil.ItemCallback<HotPepperData>() {
            override fun areItemsTheSame(
                oldRepositoryData: HotPepperData,
                newRepositoryData: HotPepperData
            ): Boolean {
                return oldRepositoryData.id == newRepositoryData.id
            }

            override fun areContentsTheSame(
                oldRepositoryData: HotPepperData,
                newRepositoryData: HotPepperData
            ): Boolean {
                return oldRepositoryData == newRepositoryData
            }
        }
    }
}