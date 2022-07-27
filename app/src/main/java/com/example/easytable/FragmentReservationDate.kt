package com.example.easytable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.example.easytable.databinding.FragmentReservationBinding
import java.util.*

class FragmentReservationDate : Fragment() {


    lateinit var  _binding: FragmentReservationBinding
    private val binding get() = _binding
    val frgTime = FragmentReservationTime()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReservationBinding.inflate(inflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()


       binding.btnSubmitDate.setOnClickListener {
           this.activity?.supportFragmentManager?.beginTransaction()
               ?.replace(R.id.change, frgTime)
               ?.addToBackStack("time")
               ?.commit()
       }


    }
}