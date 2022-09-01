package com.example.easytablevilnius.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class FoodPlace(@NotNull @PrimaryKey var name: String, var adress: String?=null)
{

}

