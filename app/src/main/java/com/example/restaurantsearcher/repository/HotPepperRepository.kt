package com.example.restaurantsearcher.repository

import com.example.restaurantsearcher.BuildConfig
import com.example.restaurantsearcher.data.SearchTerms
import com.example.restaurantsearcher.data.HotPepperResponse
import com.example.restaurantsearcher.ui.model.HotPepperService
import retrofit2.Response
import javax.inject.Inject

//オブジェクトの情報を取得する
class HotPepperRepository @Inject constructor
    (private val service: HotPepperService){
    private val key = BuildConfig.API_KEY
    private val format = "json"

    fun searchHotPepperRepository(searchTerms: SearchTerms): Response<HotPepperResponse>? {
        return try {
            service.getData(
                key,
                searchTerms.keyword,
                searchTerms.location.lat,
                searchTerms.location.lng,
                searchTerms.range,
                format
            ).execute()
        } catch (e: Exception) {
            null
        }
    }
}