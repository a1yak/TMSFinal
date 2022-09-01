package com.example.easytablevilnius.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easytablevilnius.Repo.PlacesRepo

class FoodPlacesViewModel:ViewModel() {
    private val repository: PlacesRepo
    private val _allPlaces = MutableLiveData<List<FoodPlace>>()
    val allPlaces:LiveData<List<FoodPlace>> = _allPlaces

    init {
        repository = PlacesRepo().getInstance()
        repository.loadPlaces(_allPlaces)
    }
}