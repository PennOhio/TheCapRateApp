package com.example.remvp4.ui.inputs.main


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.remvp4.data.local.Property
import com.example.remvp4.databinding.MainInputFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainInputFragment : Fragment() {


    private var _binding: MainInputFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainInputViewModel by viewModels()
    private val args: MainInputFragmentArgs by navArgs()


    companion object {
        fun newInstance() = MainInputFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("onCreate", "onCreate Called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("onStart", "onStart Called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val property: Property = args.property
        binding.title.text = property.projectName
        if (property.address != null) binding.address.setText(property.address.toString())
        if (property.askingPrice != null) binding.askingPrice.setText(property.askingPrice.toString())
        if (property.renovationExpenses != null) binding.renovationExpenses.setText(property.renovationExpenses.toString())
        if (property.monthlyRent != null) binding.monthlyRent.setText(property.monthlyRent.toString())
        if (property.expenseRatio != null) binding.expenseRatio.setText(property.expenseRatio.toString())
        if (property.marketCapRate != null) binding.marketCapRate.setText(property.marketCapRate.toString())
        viewModel.updatePropertyInRoom(
            property = args.property,
            address = if (property.address != null) {
                property.address.toString()
            } else {
                null
            },
            askingPrice = if (property.askingPrice != null) {
                property.askingPrice
            } else {
                null
            },
            renovationExpenses = if (property.renovationExpenses != null) {
                property.renovationExpenses
            } else {
                null
            },
            monthlyRent = if (property.monthlyRent != null) {
                property.monthlyRent
            } else {
                null
            },
            expenseRatio = if (property.expenseRatio != null) {
                property.expenseRatio
            } else {
                null
            },
            marketCapRate = if (property.marketCapRate != null) {
                property.marketCapRate
            } else {
                null
            },
            noi = if (property.noi != null) {
                property.noi
            } else {
                null
            },
            purchasePrice = if (property.purchasePrice != null) {
                property.purchasePrice
            } else {
                null
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("MainActivity", "onStart Called")
        _binding = MainInputFragmentBinding.inflate(inflater, container, false)
        setClickListener()

        return binding.root
    }


    private fun setClickListener() {
        binding.submit.setOnClickListener {
            if (binding.address.text.toString().isBlank() ||
                binding.askingPrice.text.toString().isBlank() ||
                binding.renovationExpenses.text.toString().isBlank() ||
                binding.monthlyRent.text.toString().isBlank() ||
                binding.expenseRatio.text.toString().isBlank() ||
                binding.marketCapRate.text.toString().isBlank()
            ) {
                Toast.makeText(requireActivity(), "Empty data", Toast.LENGTH_SHORT).show()
            } else {
                val address = binding.address.text.toString()
                val askingPrice = binding.askingPrice.text.toString().toDouble()
                val renovationExpenses = binding.renovationExpenses.text.toString().toDouble()
                val monthlyRent = binding.monthlyRent.text.toString().toDouble()
                val expenseRatio = binding.expenseRatio.text.toString().toDouble()
                val marketCapRate = binding.marketCapRate.text.toString().toDouble()
                val noi = monthlyRent * 12 * expenseRatio
                val purchasePrice = askingPrice

                viewModel.updatePropertyInRoom(
                    property = args.property,
                    address = address,
                    askingPrice = askingPrice,
                    renovationExpenses = renovationExpenses,
                    monthlyRent = monthlyRent,
                    expenseRatio = expenseRatio,
                    marketCapRate = marketCapRate,
                    noi = noi,
                    purchasePrice = purchasePrice,
                )
                findNavController().navigate(
                    MainInputFragmentDirections
                        .actionMainInputFragmentToResultsFragment(viewModel.finalProperty)
                )
                // TODO: 3/19/2021 Figure out how to return the value property to the fragment for movement using safe-args to the other fragments.  Probably by calling a recall of the subject property from the repo in the updatePropertyInRoom() function
            }
        }

        // Navigates to the recurring expenses fragment when "expense Ratio button is clicked"
        binding.toDetailedExpenseRatio.setOnClickListener {
            if (binding.address.text.toString().isBlank() ||
                binding.askingPrice.text.toString().isBlank() ||
                binding.renovationExpenses.text.toString().isBlank() ||
                binding.monthlyRent.text.toString().isBlank() ||
                binding.marketCapRate.text.toString().isBlank()){
                Toast.makeText(requireActivity(), "Empty data", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.updateDetailsInRoom(
                    property = args.property,
                    address = binding.address.text.toString(),
                    monthlyRent = binding.monthlyRent.text.toString().toDouble(),
                    askingPrice = binding.askingPrice.text.toString().toDouble(),
                    renovationExpenses = binding.renovationExpenses.text.toString().toDouble(),
                    marketCapRate = binding.marketCapRate.text.toString().toDouble()
                )
                findNavController().navigate(
                    MainInputFragmentDirections
                        .actionMainInputFragmentToExpenseRatio(viewModel.finalProperty)
                )
            }
        }
        // Navigates to the renovation expense input calculator when detailed expense button is clicked
        binding.toRenovationExpeneses.setOnClickListener {
            if (binding.address.text.toString().isBlank() ||
                binding.askingPrice.text.toString().isBlank() ||
                binding.renovationExpenses.text.toString().isBlank() ||
                binding.monthlyRent.text.toString().isBlank() ||
                binding.marketCapRate.text.toString().isBlank()){
                Toast.makeText(requireActivity(), "Empty data", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.updateDetailsInRoom(
                    property = args.property,
                    address = binding.address.text.toString(),
                    monthlyRent = binding.monthlyRent.text.toString().toDouble(),
                    askingPrice = binding.askingPrice.text.toString().toDouble(),
                    renovationExpenses = binding.renovationExpenses.text.toString().toDouble(),
                    marketCapRate = binding.marketCapRate.text.toString().toDouble()
                )
                findNavController().navigate(
                    MainInputFragmentDirections
                        .actionMainInputFragmentToRenovationExpenses(viewModel.finalProperty)
                )
            }
        }

        binding.floatingActionButton.setOnClickListener{
            viewModel.deleteProperty(property = viewModel.finalProperty)
            findNavController().navigate(MainInputFragmentDirections.actionMainInputFragmentToHomePageFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}