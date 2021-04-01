package com.example.remvp4.ui.inputs.recurringExpenses


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remvp4.data.Repository
import com.example.remvp4.data.local.Property
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseRatioViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    lateinit var finalProperty: Property

    fun updatePropertyInRoom(
            property: Property,
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
            realEstateTaxes: Double?): Property {
        property.cleaning = cleaning
        property.maintenance = maintenance
        property.leasing = leasing
        property.officeAndAdmin = officeAndAdmin
        property.managementFee = managementFee
        property.insurance = insurance
        property.nonCamUtilities = nonCamUtilities
        property.camUtilities = camUtilities
        property.replacementReserves = replacementReserves
        property.trash = trash
        property.realEstateTaxes = realEstateTaxes
        property.totalRecurringExpenses =
            property.cleaning?.
            plus(property.maintenance!!)?.
            plus(property.leasing!!)?.
            plus(property.officeAndAdmin!!)?.
            plus(property.managementFee!!)?.
            plus(property.insurance!!)?.
            plus(property.nonCamUtilities!!)?.
            plus(property.camUtilities!!)?.
            plus(property.replacementReserves!!)?.
            plus(property.trash!!)?.
            plus(property.realEstateTaxes!!)
        val annualRent = property.monthlyRent?.times(12)
        property.expenseRatio = property.totalRecurringExpenses?.div(annualRent!!)
        finalProperty = property

        viewModelScope.launch {
            repository.insert(property)
        }

        return finalProperty

    }



}