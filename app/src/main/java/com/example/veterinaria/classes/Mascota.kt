package com.example.veterinaria.classes

import android.os.Parcel
import android.os.Parcelable
import java.util.Date
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mascota")
data class Mascota(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var nombre: String,
    var fechaNacimiento: Date,
    val foto: String,
    var peso: Double,
    val raza: Raza
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        Date(parcel.readLong()),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readParcelable(Raza::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombre)
        parcel.writeLong(fechaNacimiento.time)
        parcel.writeString(foto)
        parcel.writeDouble(peso)
        parcel.writeParcelable(raza, flags)
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