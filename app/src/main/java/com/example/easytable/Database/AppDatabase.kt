package com.example.easytable.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.easytable.Dao.FoodPlaceDao
import com.example.easytable.Dao.PersonDao
import com.example.easytable.Dao.ReservationDao
import com.example.easytable.Models.FoodPlace
import com.example.easytable.Models.Person
import com.example.easytable.Models.Reservation
import com.example.easytable.Service.Converters

@Database(entities = [Reservation::class, Person::class, FoodPlace::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase:RoomDatabase() {

    abstract fun reservationDao(): ReservationDao

    abstract fun personDao(): PersonDao

    abstract fun foodplaceDao(): FoodPlaceDao

    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }

            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}