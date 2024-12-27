package com.example.loveapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.loveapp.R
import com.example.loveapp.databinding.FragmentOnBoardPagerBinding
import com.example.loveapp.utils.PreferenceHelper

class OnBoardPagerFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentOnBoardPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.unit(requireContext())
        btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_calculateFragment)
            sharedPreferences.isOnBoardShown = true
        }
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0 -> {
                txtTitle.text = "Have a good time"
                txtBody.text = "You should take the time to help those who need you"
                btnStart.visibility = View.INVISIBLE

            }
            1 -> {
                txtTitle.text = "Cherishing love"
                txtBody.text = "It is now no longer possible for you to cherish love"
                btnStart.visibility = View.INVISIBLE
            }
            2 -> {
                txtTitle.text = "Have a breakup?"
                txtBody.text = "We have made the correction for you don't worry Maybe someone is waiting for you!"
                btnStart.visibility = View.VISIBLE
            }
        }
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}