package com.example.restaurantsearcher.data

import java.io.Serializable

data class SearchTerms(
    val keyword: String,
    val location: LocationData,
    val range: Int,
): Serializable
