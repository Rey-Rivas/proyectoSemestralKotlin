package com.example.veterinaria.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veterinaria.adapters.TratamientoAdapter
import com.example.veterinaria.databinding.FragmentRvTratamientosBinding
import com.example.veterinaria.viewModels.TratamientoViewModel

class TreatmentFragment : Fragment() {
    private var _binding: FragmentRvTratamientosBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TratamientoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRvTratamientosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TratamientoAdapter(emptyList()) { tratamiento ->
            // Handle item click
        }

        binding.tratamientoRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.tratamientoRecyclerView.adapter = adapter

        viewModel.tratamientos.observe(viewLifecycleOwner) { tratamientos ->
            adapter.updateTratamientos(tratamientos)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}