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
import com.example.easytable.databinding.FragmentReservationTimeBinding
import java.util.*


class FragmentReservationTime : Fragment() {



    lateinit var  _binding: FragmentReservationTimeBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReservationTimeBinding.inflate(inflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
    }

    }
