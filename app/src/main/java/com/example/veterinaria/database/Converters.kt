package com.example.veterinaria.database

import androidx.room.TypeConverter
import com.example.veterinaria.classes.Raza
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromRaza(value: String): Raza {
        val type = object : TypeToken<Raza>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun razaToString(raza: Raza): String {
        return Gson().toJson(raza)
    }
}