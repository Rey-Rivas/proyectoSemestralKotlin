package com.example.veterinaria.classes

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

data class Mascota (
    val id: Int,
    var nombre: String,
    val fechaNacimiento: Date, // Usar formato de fecha adecuado
    val foto: String, // Ruta de la foto
    val peso: Double,
    val raza: Raza // Reference to Raza
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        Date(parcel.readLong()), // Convert long to Date
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readParcelable(Raza::class.java.classLoader)!! // Read Raza from Parcel
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombre)
        parcel.writeLong(fechaNacimiento.time) // Convert Date to long
        parcel.writeString(foto)
        parcel.writeDouble(peso)
        parcel.writeParcelable(raza, flags) // Write Raza to Parcel
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mascota> {
        override fun createFromParcel(parcel: Parcel): Mascota {
            return Mascota(parcel)
        }

        override fun newArray(size: Int): Array<Mascota?> {
            return arrayOfNulls(size)
        }
    }
}