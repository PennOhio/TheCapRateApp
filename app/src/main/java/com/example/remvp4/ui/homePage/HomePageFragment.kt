package com.example.remvp4.ui.homePage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.remvp4.databinding.HomePageFragmentBinding
import com.example.remvp4.util.PropertyAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {

    private var _binding: HomePageFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = HomePageFragment()
    }

    private val viewModel: HomePageViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomePageFragmentBinding.inflate(inflater, container, false)
        val adapter = PropertyAdapter()
        binding.propertyList.adapter = adapter
        viewModel.propertyList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })
        setClickListener()
        return binding.root
    }

    private fun setClickListener() {
        // Navigates to the results Fragment on the "see results" button
        binding.addPropertyFab.setOnClickListener {
            //When FAB button is clicked, input and create property button pop up and fab disappears
            binding.addPropertyFab.isVisible = false
            binding.newProjectInputHolder.isVisible = true
            binding.createProject.isVisible = true

        }

        binding.createProject.setOnClickListener {
            if (binding.newProjectInput.text.toString().isBlank()
            ) {
                Toast.makeText(
                    requireActivity(),
                    "Oops! Your Project Needs a Name",
                    Toast.LENGTH_SHORT
                ).show()
                // TODO: 3/19/2021 Make sure overwrites of the project are "are you sure?"
            } else {
                val projectName = binding.newProjectInput.text.toString()
                val address: String? = null
                val askingPrice: Double? = null
                val renovationExpenses: Double? = null
                val monthlyRent: Double? = null
                val expenseRatio: Double? = null
                val marketCapRate: Double? = null
                val noi: Double? = null
                val calculatedPropertyValue: Double? = null
                val purchasePrice: Double? = null
                val calculatedCapRate: Double? = null
                val cleaning: Double? = null
                val maintenance: Double? = null
                val leasing: Double? = null
                val officeAndAdmin: Double? = null
                val managementFee: Double? = null
                val insurance: Double? = null
                val nonCamUtilities: Double? = null
                val camUtilities: Double? = null
                val replacementReserves: Double? = null
                val trash: Double? = null
                val realEstateTaxes: Double? = null
                val kitchen: Double? = null
                val bathrooms: Double? = null
                val paint: Double? = null
                val windows: Double? = null
                val flooring: Double? = null
                val drywall: Double? = null
                val plumbing: Double? = null
                val electric: Double? = null
                val doors: Double? = null
                val hvac: Double? = null
                viewModel.savePropertyToRoom(
                    projectName = projectName,
                    address = address,
                    askingPrice = askingPrice,
                    renovationExpenses = renovationExpenses,
                    monthlyRent = monthlyRent,
                    expenseRatio = expenseRatio,
                    marketCapRate = marketCapRate,
                    noi = noi,
                    calculatedPropertyValue = calculatedPropertyValue,
                    purchasePrice = purchasePrice,
                    calculatedCapRate = calculatedCapRate,
                    cleaning = cleaning,
                    maintenance = maintenance,
                    leasing = leasing,
                    officeAndAdmin = officeAndAdmin,
                    managementFee = managementFee,
                    insurance = insurance,
                    nonCamUtilities = nonCamUtilities,
                    camUtilities = camUtilities,
                    replacementReserves = replacementReserves,
                    trash = trash,
                    realEstateTaxes = realEstateTaxes,
                    kitchen = kitchen,
                    bathrooms = bathrooms,
                    paint = paint,
                    windows = windows,
                    flooring = flooring,
                    drywall = drywall,
                    plumbing = plumbing,
                    electric = electric,
                    doors = doors,
                    hvac = hvac
                )
                // navigates from the homepage fragment to the Main Input Fragment while passing args of the property object using Parcelize
                findNavController().navigate(
                    HomePageFragmentDirections.actionHomePageFragmentToMainInputFragment(property = viewModel.property)
                )
            }

        }

    }


}