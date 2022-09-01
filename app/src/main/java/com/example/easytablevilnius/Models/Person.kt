package com.example.easytablevilnius.Models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "people")
data class Person(@PrimaryKey(autoGenerate = true) val id: Int?,
                  ){

}
