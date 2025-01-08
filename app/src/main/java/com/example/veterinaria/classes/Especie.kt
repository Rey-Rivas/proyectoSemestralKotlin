package com.example.veterinaria.classes

import android.os.Parcel
import android.os.Parcelable

data class Especie(
    val idEspecie: Int,
    val nombre: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idEspecie)
        parcel.writeString(nombre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Especie> {
        override fun createFromParcel(parcel: Parcel): Especie {
            return Especie(parcel)
        }

        override fun newArray(size: Int): Array<Especie?> {
            return arrayOfNulls(size)
        }
    }
}