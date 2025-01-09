package com.example.veterinaria.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinaria.databinding.ItemConsultasBinding
import com.example.veterinaria.classes.Consulta

class ConsultaAdapter(
    private var consultaList: List<Consulta>,
    private val onItemClick: (Consulta) -> Unit
) : RecyclerView.Adapter<ConsultaAdapter.ConsultaViewHolder>() {

    class ConsultaViewHolder(val binding: ItemConsultasBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultaViewHolder {
        val binding = ItemConsultasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConsultaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConsultaViewHolder, position: Int) {
        val consulta = consultaList[position]
        holder.binding.consulta = consulta
        holder.binding.executePendingBindings()

        holder.binding.root.setOnClickListener {
            onItemClick(consulta)
        }
    }

    override fun getItemCount() = consultaList.size

    fun updateConsultas(newConsultas: List<Consulta>) {
        consultaList = newConsultas
        notifyDataSetChanged()
    }
}