package com.example.restaurantsearcher.ui.viewmodel

import android.content.Context
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurantsearcher.data.LocationData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.location.LocationServices

class LoadViewModel : ViewModel() {
    private val _locationData = MutableLiveData<LocationData>()
    val locationData: LiveData<LocationData> get() = _locationData

    private val _errorState = MutableLiveData<Boolean>()
    val errorState: LiveData<Boolean> get() = _errorState


    fun getLocation(context: Context) {
        try {
            // 最後に確認された位置情報を取得
            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
            // 位置情報を取得したらListenerが反応する
            fusedLocationClient.lastLocation.addOnCompleteListener(locationCompleteListener)
        } catch (e: SecurityException) {
            handleLocationError()
        }
    }

    private val locationCompleteListener = OnCompleteListener { task ->
        try {
            if (task.isSuccessful && task.result != null) {
                handleLocationSuccess(task.result)
            } else {
                handleLocationError()
            }
        } catch (e: Exception) {
            handleLocationError()
        }
    }

    //座標の取得
    private fun handleLocationSuccess(location: Location) {
        val locationData = LocationData(location.latitude, location.longitude)
        _locationData.value = locationData
    }

    private fun handleLocationError() {
        _errorState.value = true
    }
}