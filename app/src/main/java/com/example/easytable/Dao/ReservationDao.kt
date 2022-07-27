package com.example.easytable.Dao

import androidx.room.*
import com.example.easytable.Models.Reservation

@Dao
interface ReservationDao {
    @Query("SELECT * FROM reservation")
    fun getAll(): List<Reservation>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add(reservation: Reservation)

    @Delete()
    fun delete(reservation: Reservation)
}