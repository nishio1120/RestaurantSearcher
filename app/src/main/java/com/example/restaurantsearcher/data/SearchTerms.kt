package com.example.restaurantsearcher.data

import com.example.restaurantsearcher.data.LocationData
import java.io.Serializable

data class SearchTerms(
    val keyword: String,
    val location: LocationData,
    val range: Int,
): Serializable
