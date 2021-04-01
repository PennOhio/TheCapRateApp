package com.example.remvp4.ui.inputs.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remvp4.data.Repository
import com.example.remvp4.data.local.Property
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainInputViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    lateinit var finalProperty: Property

    fun updatePropertyInRoom(
        property: Property,
        address: String?,
        askingPrice: Double?,
        renovationExpenses: Double?,
        monthlyRent: Double?,
        expenseRatio: Double?,
        marketCapRate: Double?,
        noi: Double?,
        purchasePrice: Double?,
    ): Property {
        property.address = address
        property.askingPrice = askingPrice
        property.renovationExpenses = renovationExpenses
        property.monthlyRent = monthlyRent
        property.expenseRatio = expenseRatio
        if (property.totalRecurringExpenses != null && property.monthlyRent != null) {
            property.expenseRatio = 1- property.totalRecurringExpenses!! / (property.monthlyRent!! * 12)
        }
        property.marketCapRate = marketCapRate
        if (property.monthlyRent != null && property.expenseRatio != null) {
            property.noi = monthlyRent!! * 12 * (property.expenseRatio!!)
        }
        if (property.noi != null && property.marketCapRate != null) {
            property.calculatedPropertyValue = noi!! / marketCapRate!!
        }
        property.purchasePrice = askingPrice
        if (property.noi != null && purchasePrice != null && renovationExpenses != null) {
            property.calculatedCapRate = property.noi!! / (property.purchasePrice!! + property.renovationExpenses!!)
        }

        viewModelScope.launch {
            repository.insert(property)
        }
        finalProperty = property
        return finalProperty
    }

    fun deleteProperty(property: Property) {
        viewModelScope.launch {
            repository.delete(property)
        }
    }

    fun updateDetailsInRoom(
        property: Property,
        address: String?,
        askingPrice: Double?,
        renovationExpenses: Double?,
        monthlyRent: Double?,
        marketCapRate: Double?
    ): Property {
        property.address = address
        property.askingPrice = askingPrice
        property.renovationExpenses = renovationExpenses
        property.monthlyRent = monthlyRent
        property.marketCapRate = marketCapRate
        viewModelScope.launch {
            repository.insert(property)
        }
        finalProperty = property
        return finalProperty
    }
}