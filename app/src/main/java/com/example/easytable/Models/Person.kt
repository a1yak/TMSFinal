package com.example.easytable.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime


@Entity(tableName = "people")
data class Person(@PrimaryKey(autoGenerate = true) val id: Int?,
                  ){

}
