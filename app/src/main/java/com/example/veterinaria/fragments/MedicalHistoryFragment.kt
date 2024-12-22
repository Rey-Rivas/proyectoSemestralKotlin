package com.example.veterinaria.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.veterinaria.classes.Mascota
import com.example.veterinaria.databinding.FragmentMedicalHistoryBinding

class MedicalHistoryFragment : Fragment() {
    private var mascota: Mascota? = null
    private var _binding: FragmentMedicalHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mascota = it.getParcelable("mascota")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMedicalHistoryBinding.inflate(inflater, container, false)
        binding.mascota = mascota // Enlazar los datos
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
