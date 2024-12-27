package com.example.loveapp.ui.fragments

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.loveapp.data.model.LoveModel
import com.example.loveapp.databinding.FragmentCalculateBinding
import com.example.loveapp.ui.base.BaseFragment
import com.example.loveapp.ui.viewmodels.LoveViewModel

class CalculateFragment : BaseFragment<FragmentCalculateBinding>(
    FragmentCalculateBinding::inflate
) {

    private val viewModel: LoveViewModel by viewModels()

    override fun setupObservers() {
        viewModel.loveResult.observe(viewLifecycleOwner) { result ->
            if (result != null) {
                binding.etFirstName.text.clear()
                binding.etSecondName.text.clear()
                result.apply {
                    findNavController().navigate(
                        CalculateFragmentDirections.actionCalculateFragmentToResultFragment4(
                            LoveModel(
                                firstName,
                                secondName,
                                percentage,
                                result.result
                            )
                        )
                    )
                }
            }
        }

        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }

        viewModel.loadingProgressBar.observe(viewLifecycleOwner) {
            if (it) binding.pbCalculate.visibility = View.VISIBLE
        }
    }

    override fun setupClickListeners() {
        binding.btnCalculate.setOnClickListener() {
            viewModel.getPercentage(
                binding.etFirstName.text.toString(),
                binding.etSecondName.text.toString()
            )
        }
    }
}