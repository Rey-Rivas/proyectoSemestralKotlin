package com.example.veterinaria.classes

import android.os.Parcel
import android.os.Parcelable

data class Raza(
    val idRaza: Int,
    val nombre: String,
    val especie: List<Especie>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.createTypedArrayList(Especie.CREATOR)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idRaza)
        parcel.writeString(nombre)
        parcel.writeTypedList(especie)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Raza> {
        override fun createFromParcel(parcel: Parcel): Raza {
            return Raza(parcel)
        }

        override fun newArray(size: Int): Array<Raza?> {
            return arrayOfNulls(size)
        }
    }
}