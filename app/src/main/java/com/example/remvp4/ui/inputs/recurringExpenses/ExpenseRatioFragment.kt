package com.example.remvp4.ui.inputs.recurringExpenses


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.remvp4.data.local.Property
import com.example.remvp4.databinding.ExpenseRatioFragmentBinding
import com.example.remvp4.ui.inputs.main.MainInputFragmentArgs

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpenseRatioFragment : Fragment() {

    private var _binding: ExpenseRatioFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ExpenseRatioViewModel by viewModels()
    private val args: MainInputFragmentArgs by navArgs()

    companion object {
        fun newInstance() = ExpenseRatioFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val property: Property = args.property
        binding.expenseRatioViewTitle.text = property.projectName
        if (property.cleaning != null) binding.cleaning.setText(property.cleaning.toString())
        if (property.maintenance != null) binding.maintenance.setText(property.maintenance.toString())
        if (property.leasing != null) binding.leasing.setText(property.leasing.toString())
        if (property.officeAndAdmin != null) binding.officeAndAdmin.setText(property.officeAndAdmin.toString())
        if (property.managementFee != null) binding.managementFee.setText(property.managementFee.toString())
        if (property.insurance != null) binding.insurance.setText(property.insurance.toString())
        if (property.nonCamUtilities != null) binding.nonCamUtilities.setText(property.nonCamUtilities.toString())
        if (property.camUtilities != null) binding.commonAreaUtilities.setText(property.camUtilities.toString())
        if (property.replacementReserves != null) binding.replacementReserves.setText(property.replacementReserves.toString())
        if (property.trash != null) binding.trash.setText(property.trash.toString())
        if (property.realEstateTaxes != null) binding.realEstateTaxes.setText(property.realEstateTaxes.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ExpenseRatioFragmentBinding.inflate(inflater, container, false)
        setClickListener()
        return binding.root
    }

    private fun setClickListener() {
        binding.submitExpenses.setOnClickListener{
            viewModel.updatePropertyInRoom(
                property = args.property,
                cleaning = binding.cleaning.text.toString().toDouble(),
                maintenance = binding.cleaning.text.toString().toDouble(),
                leasing = binding.cleaning.text.toString().toDouble(),
                officeAndAdmin = binding.cleaning.text.toString().toDouble(),
                managementFee = binding.cleaning.text.toString().toDouble(),
                insurance = binding.insurance.text.toString().toDouble(),
                nonCamUtilities = binding.cleaning.text.toString().toDouble(),
                camUtilities = binding.cleaning.text.toString().toDouble(),
                replacementReserves = binding.cleaning.text.toString().toDouble(),
                trash = binding.cleaning.text.toString().toDouble(),
                realEstateTaxes = binding.cleaning.text.toString().toDouble()
            )
            findNavController().navigate(ExpenseRatioFragmentDirections
                .actionExpenseRatioToMainInputFragment(viewModel.finalProperty))
        }
    }



}