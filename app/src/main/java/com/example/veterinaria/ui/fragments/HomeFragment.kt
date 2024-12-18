package com.example.veterinaria.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veterinaria.adapters.MascotaAdapter
import com.example.veterinaria.databinding.FragmentHomeBinding
import com.example.veterinaria.viewModels.MascotaViewModel

class HomeFragment : Fragment() {
    private val mascotaViewModel = MascotaViewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = this
        _binding?.mascotaViewModel = mascotaViewModel

        val recyclerView = _binding?.mascotaRecyclerView
        recyclerView?.layoutManager = LinearLayoutManager(context)

        mascotaViewModel.mascotaList.observe(viewLifecycleOwner, Observer { mascotas ->
            recyclerView?.adapter = MascotaAdapter(mascotas)
        })

        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}