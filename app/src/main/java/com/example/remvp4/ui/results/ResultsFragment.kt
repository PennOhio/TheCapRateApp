package com.example.remvp4.ui.results

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.remvp4.R
import com.example.remvp4.data.local.Property
import com.example.remvp4.databinding.MainInputFragmentBinding
import com.example.remvp4.databinding.ResultsFragmentBinding
import com.example.remvp4.ui.inputs.main.MainInputFragmentArgs
import com.example.remvp4.ui.inputs.main.MainInputViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToLong

@AndroidEntryPoint
class ResultsFragment : Fragment() {

    private var _binding: ResultsFragmentBinding? = null
    private val binding get() = _binding!!
    val args: ResultsFragmentArgs by navArgs()

    private val viewModel: ResultsViewModel by viewModels()

    companion object {
        fun newInstance() = ResultsFragment()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val property: Property = args.property
        addProperty(property)
        binding.title.text = property.projectName
        binding.NOI.text = "$ %.2f".format(property.noi)
        binding.purchasePrice.setText("%.2f".format(property.purchasePrice))
        binding.capRate.text = "%.3f".format(property.calculatedCapRate)
        binding.propertyValue.text = "$ %.2f".format(property.calculatedPropertyValue)
    }

    private fun addProperty(property: Property) {
        viewModel.addProperty(property)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ResultsFragmentBinding.inflate(inflater, container, false)
        setClickListener()
        return binding.root
    }

    private fun setClickListener() {
        binding.refreshOffer.setOnClickListener{
            viewModel.updatePrice(args.property, binding.purchasePrice.text.toString().toDouble())
            binding.capRate.text = "%.3f".format(viewModel.finalProperty.calculatedCapRate)
        }

    }


}