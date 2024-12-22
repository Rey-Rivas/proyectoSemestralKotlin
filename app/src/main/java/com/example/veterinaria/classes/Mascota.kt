package com.example.veterinaria.classes

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

data class Mascota(
    val id: Int,
    var nombre: String,
    val fechaNacimiento: Date, // Usar formato de fecha adecuado
    val foto: String, // Ruta de la foto
    val peso: Double,
    //val raza: Raza,
    //val registroMedico: RegistroMedico
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        TODO("fechaNacimiento"),
        parcel.readString().toString(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombre)
        parcel.writeString(foto)
        parcel.writeDouble(peso)
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