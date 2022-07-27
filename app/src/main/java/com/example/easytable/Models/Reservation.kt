package com.example.easytable.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="reservation")
data class Reservation(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "reservation_date") val date: String,
    @ColumnInfo(name = "reservation_time") val time: String,
){

}
