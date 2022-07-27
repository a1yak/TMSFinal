package com.example.easytable.Service

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.time.LocalDate
import java.time.LocalTime


class Converters {

    val gson = Gson()
    @TypeConverter
    fun dateToString(localDate: LocalDate): String{
        return gson.toJson(localDate)
    }

    @TypeConverter
    fun timeToString(localTime: LocalTime): String{
        return gson.toJson(localTime)
    }

    @TypeConverter
    fun stringToDate(string: String):LocalDate{
        val objectType= object : TypeToken<LocalDate>() {}.type
       return gson.fromJson(string, objectType)
    }

    @TypeConverter
    fun stringToTime(string: String): LocalTime{
        val objectType= object : TypeToken<LocalTime>() {}.type
        return gson.fromJson(string, objectType)
    }
}