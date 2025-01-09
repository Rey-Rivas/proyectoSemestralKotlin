package com.example.veterinaria.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.veterinaria.classes.Mascota
import com.example.veterinaria.databinding.FragmentEditarFichaMedicaBinding
import com.example.veterinaria.viewModels.MascotaViewModel
import java.text.SimpleDateFormat
import java.util.Locale

class EditMascotaFragment : Fragment() {
    private var mascota: Mascota? = null
    private var _binding: FragmentEditarFichaMedicaBinding? = null
    private val binding get() = _binding!!
    private val mascotaViewModel: MascotaViewModel by viewModels()

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
        _binding = FragmentEditarFichaMedicaBinding.inflate(inflater, container, false)


        binding.editTextText.setText(mascota?.nombre)
        binding.editTextText3.setText(mascota?.peso.toString())
        binding.editTextText4.setText(mascota?.raza?.especie?.joinToString { it.nombre })
        binding.editTextText5.setText(mascota?.raza?.nombre)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        binding.editTextDate2.setText(mascota?.fechaNacimiento?.let { dateFormat.format(it) })


        binding.btnSave.setOnClickListener {

            mascota?.apply {
                nombre = binding.editTextText.text.toString()
                peso = binding.editTextText3.text.toString().toDouble()
                raza.nombre = binding.editTextText5.text.toString()
                fechaNacimiento = dateFormat.parse(binding.editTextDate2.text.toString())
            }

           mascotaViewModel.updateMascota(mascota)

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}