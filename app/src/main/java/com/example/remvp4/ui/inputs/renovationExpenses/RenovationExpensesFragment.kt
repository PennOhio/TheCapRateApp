package com.example.remvp4.ui.inputs.renovationExpenses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.remvp4.data.local.Property
import com.example.remvp4.databinding.RenovationExpensesFragmentBinding
import com.example.remvp4.ui.inputs.main.MainInputFragmentArgs
import com.example.remvp4.ui.inputs.recurringExpenses.ExpenseRatioFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RenovationExpensesFragment : Fragment() {

    private var _binding: RenovationExpensesFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RenovationExpensesViewModel by viewModels()
    private val args: MainInputFragmentArgs by navArgs()

    companion object {
        fun newInstance() = RenovationExpensesFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val property: Property = args.property
        binding.projectName.text = property.projectName
        if (property.kitchen != null) binding.kitchen.setText(property.kitchen.toString())
        if (property.bathrooms != null) binding.bathrooms.setText(property.bathrooms.toString())
        if (property.paint != null) binding.paint.setText(property.paint.toString())
        if (property.windows != null) binding.windows.setText(property.windows.toString())
        if (property.flooring != null) binding.flooring.setText(property.flooring.toString())
        if (property.drywall != null) binding.drywall.setText(property.drywall.toString())
        if (property.plumbing != null) binding.plumbing.setText(property.plumbing.toString())
        if (property.electric != null) binding.electric.setText(property.electric.toString())
        if (property.doors != null) binding.doors.setText(property.doors.toString())
        if (property.hvac != null) binding.hvac.setText(property.hvac.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RenovationExpensesFragmentBinding.inflate(inflater, container, false)
        setClickListener()
        return binding.root
    }

    private fun setClickListener() {
        binding.submitExpenses.setOnClickListener{
            viewModel.updatePropertyInRoom(
                property = args.property,
                bathrooms = binding.bathrooms.text.toString().toDouble(),
                paint = binding.paint.text.toString().toDouble(),
                windows = binding.windows.text.toString().toDouble(),
                flooring = binding.flooring.text.toString().toDouble(),
                drywall = binding.drywall.text.toString().toDouble(),
                plumbing = binding.plumbing.text.toString().toDouble(),
                electric = binding.electric.text.toString().toDouble(),
                doors = binding.doors.text.toString().toDouble(),
                hvac = binding.hvac.text.toString().toDouble(),
            )
            findNavController().navigate(
                RenovationExpensesFragmentDirections
                .actionRenovationExpensesToMainInputFragment(viewModel.finalProperty))
        }
    }



}