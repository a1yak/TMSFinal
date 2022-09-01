package com.example.easytablevilnius.Dao

import androidx.room.*
import com.example.easytablevilnius.Models.Reservation

@Dao
interface ReservationDao {
    @Query("SELECT * FROM reservation")
    fun getAll(): List<Reservation>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add(reservation: Reservation)

    @Delete()
    fun delete(reservation: Reservation)
}