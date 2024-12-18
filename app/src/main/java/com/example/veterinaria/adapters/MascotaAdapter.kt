package com.example.veterinaria.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinaria.databinding.ItemMascotaBinding
import com.example.veterinaria.data.models.Mascota

class MascotaAdapter(private val mascotaList: List<Mascota>) :
    RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    class MascotaViewHolder(val binding: ItemMascotaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val binding = ItemMascotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MascotaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = mascotaList[position]
        holder.binding.mascota = mascota
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = mascotaList.size
}