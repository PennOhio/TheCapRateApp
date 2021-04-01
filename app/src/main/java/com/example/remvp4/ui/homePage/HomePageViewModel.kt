package com.example.remvp4.ui.homePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remvp4.data.Repository
import com.example.remvp4.data.local.Property
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    lateinit var property: Property
    val propertyList = repository.getAll()


    fun savePropertyToRoom(
        projectName: String,
        address: String?,
        askingPrice: Double?,
        renovationExpenses: Double?,
        monthlyRent: Double?,
        expenseRatio: Double?,
        marketCapRate: Double?,
        noi: Double?,
        calculatedPropertyValue: Double?,
        purchasePrice: Double?,
        calculatedCapRate: Double?,
        cleaning: Double?,
        maintenance: Double?,
        leasing: Double?,
        officeAndAdmin: Double?,
        managementFee: Double?,
        insurance: Double?,
        nonCamUtilities: Double?,
        camUtilities: Double?,
        replacementReserves: Double?,
        trash: Double?,
        realEstateTaxes: Double?,
        kitchen: Double?,
        bathrooms: Double?,
        paint: Double?,
        windows: Double?,
        flooring: Double?,
        drywall: Double?,
        plumbing: Double?,
        electric: Double?,
        doors: Double?,
        hvac: Double?
    ): Property {
        property = Property(
            projectName = projectName,
            address = address,
            askingPrice = askingPrice,
            renovationExpenses = renovationExpenses,
            monthlyRent = monthlyRent,
            expenseRatio = expenseRatio,
            marketCapRate = marketCapRate,
            noi = null,
            calculatedPropertyValue = null,
            purchasePrice = null,
            calculatedCapRate = null,
            cleaning = null,
            maintenance = null,
            leasing = null,
            officeAndAdmin = null,
            managementFee = null,
            insurance = null,
            nonCamUtilities = null,
            camUtilities = null,
            replacementReserves = null,
            trash = null,
            realEstateTaxes = null,
            totalRecurringExpenses = null,
            kitchen = null,
            bathrooms = null,
            paint = null,
            windows = null,
            flooring = null,
            drywall = null,
            plumbing = null,
            electric = null,
            doors = null,
            hvac = null
        )
        viewModelScope.launch {
            repository.insert(property)
        }
        return property
    }

    fun getOne(projectName: String) = viewModelScope.launch {
        repository.getOne(projectName)
    }

}