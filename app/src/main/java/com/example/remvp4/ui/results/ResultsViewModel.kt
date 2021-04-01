package com.example.remvp4.ui.results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remvp4.data.Repository
import com.example.remvp4.data.local.Property

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    lateinit var finalProperty: Property

    fun updatePrice(property: Property, purchasePrice : Double): Property {
        property.purchasePrice = purchasePrice
        property.calculatedCapRate = property.noi!! / property.purchasePrice!!
        viewModelScope.launch {
            repository.insert(property)
        }
        return finalProperty
    }

    fun addProperty(property: Property): Property {
        finalProperty = property
        return finalProperty
    }


}