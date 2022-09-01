package com.example.easytablevilnius.Repo

import androidx.lifecycle.MutableLiveData
import com.example.easytablevilnius.Models.FoodPlace
import com.google.firebase.database.*

class PlacesRepo {
    private val database:DatabaseReference=FirebaseDatabase.getInstance().getReference("cafes")

    @Volatile private var INSTANCE : PlacesRepo ?= null

   fun getInstance():PlacesRepo {
       return INSTANCE ?: synchronized(this){

           val instance = PlacesRepo()
           INSTANCE = instance
           instance
       }

   }

    fun loadPlaces(placeList : MutableLiveData<List<FoodPlace>>){

        database.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               try {

                   val _placeList:List<FoodPlace> = snapshot.children.map{
                       dataSnapshot ->   dataSnapshot.getValue(FoodPlace::class.java)!!
                   }

                   placeList.postValue(_placeList)
               }catch (e:Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}