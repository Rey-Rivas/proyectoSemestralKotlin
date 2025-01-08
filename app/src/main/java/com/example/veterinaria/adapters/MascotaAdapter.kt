package com.example.veterinaria.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinaria.databinding.ItemMascotaBinding
import com.example.veterinaria.classes.Mascota

class MascotaAdapter(
    private val mascotaList: List<Mascota>,
    private val onItemClick: (Mascota) -> Unit // Listener para manejar los clics
) : RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    class MascotaViewHolder(val binding: ItemMascotaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val binding = ItemMascotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MascotaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = mascotaList[position]
        holder.binding.mascota = mascota
        holder.binding.executePendingBindings()

        // Configurar el clic en el elemento
        holder.binding.root.setOnClickListener {
            onItemClick(mascota)
        }
    }

    override fun getItemCount() = mascotaList.size
}
