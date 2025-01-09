package com.example.veterinaria.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veterinaria.adapters.ConsultaAdapter
import com.example.veterinaria.databinding.FragmentRvConsultaBinding
import com.example.veterinaria.viewModels.ConsultaViewModel

class ConsultFragment : Fragment() {
    private var _binding: FragmentRvConsultaBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ConsultaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRvConsultaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ConsultaAdapter(emptyList()) { consulta ->
            // Handle item click
        }

        binding.consultaRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.consultaRecyclerView.adapter = adapter

        viewModel.consultas.observe(viewLifecycleOwner) { consultas ->
            adapter.updateConsultas(consultas)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}