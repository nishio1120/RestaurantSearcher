package com.example.restaurantsearcher.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.restaurantsearcher.databinding.FragmentRestaurantScreenBinding
import com.example.restaurantsearcher.ui.viewmodel.RestaurantScreenViewModel

class RestaurantScreenFragment : Fragment() {
    private var _binding: FragmentRestaurantScreenBinding? = null
    private val binding get() = _binding!!
    private val args: RestaurantScreenFragmentArgs by navArgs()
    private val viewModel: RestaurantScreenViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantScreenBinding.inflate(inflater, container, false)
        binding.restaurant = args.restaurantData

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.url.observe(viewLifecycleOwner) {
            startActivity(Intent(Intent.ACTION_VIEW, it.toUri()))
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}