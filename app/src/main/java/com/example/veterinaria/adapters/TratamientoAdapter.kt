package com.example.veterinaria.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinaria.databinding.ItemTratamientosBinding
import com.example.veterinaria.classes.Tratamiento

class TratamientoAdapter(
    private var tratamientoList: List<Tratamiento>,
    private val onItemClick: (Tratamiento) -> Unit
) : RecyclerView.Adapter<TratamientoAdapter.TratamientoViewHolder>() {

    class TratamientoViewHolder(val binding: ItemTratamientosBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TratamientoViewHolder {
        val binding = ItemTratamientosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TratamientoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TratamientoViewHolder, position: Int) {
        val tratamiento = tratamientoList[position]
        holder.binding.tratamiento = tratamiento
        holder.binding.executePendingBindings()

        holder.binding.root.setOnClickListener {
            onItemClick(tratamiento)
        }
    }

    override fun getItemCount() = tratamientoList.size

    fun updateTratamientos(newTratamientos: List<Tratamiento>) {
        tratamientoList = newTratamientos
        notifyDataSetChanged()
    }
}