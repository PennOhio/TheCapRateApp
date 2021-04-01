package com.example.remvp4.ui.inputs.renovationExpenses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remvp4.data.Repository
import com.example.remvp4.data.local.Property
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext.plus

@HiltViewModel
class RenovationExpensesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    lateinit var finalProperty: Property

    fun updatePropertyInRoom(
        property: Property,
        bathrooms: Double?,
        paint: Double?,
        windows: Double?,
        flooring: Double?,
        drywall: Double?,
        plumbing: Double?,
        electric: Double?,
        doors: Double?,
        hvac: Double?,
        ): Property {
        property.bathrooms = bathrooms
        property.paint = paint
        property.windows = windows
        property.flooring = flooring
        property.drywall = drywall
        property.plumbing = plumbing
        property.electric = electric
        property.doors = doors
        property.hvac = hvac
        property.renovationExpenses =
            property.bathrooms?.
            plus(property.paint!!)?.
            plus(property.windows!!)?.
            plus(property.flooring!!)?.
            plus(property.drywall!!)?.
            plus(property.plumbing!!)?.
            plus(property.electric!!)?.
            plus(property.doors!!)?.
            plus(property.hvac!!)
        finalProperty = property

        viewModelScope.launch {
            repository.insert(property)
        }

        return finalProperty

    }



}