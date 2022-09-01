package com.example.easytablevilnius.fragments

import android.app.DatePickerDialog
import android.app.Dialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult

import com.example.easytablevilnius.databinding.FragmentReservationDateBinding
import java.text.SimpleDateFormat
import java.util.*


class FragmentReservationDate : DialogFragment(), DatePickerDialog.OnDateSetListener {


    private var _binding: FragmentReservationDateBinding?=null
    private val binding get() = _binding
    @RequiresApi(Build.VERSION_CODES.N)
    private val calendar = Calendar.getInstance()

    val frgTime = FragmentReservationTime()
    private var bundle:Bundle? =Bundle(3)


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(requireContext(), this, year, month, day).show()
        return DatePickerDialog(requireContext(), this, year, month, day)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReservationDateBinding.inflate(inflater)
        return binding!!.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onStart() {
        super.onStart()

       binding?.btnSubmitDate?.setOnClickListener {
          /* this.activity?.supportFragmentManager?.beginTransaction()
               ?.replace(R.id.change, frgTime)
               ?.addToBackStack("time")
               ?.commit()*/
       }
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        val selectedDate = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.time)
        bundle?.putString("date", selectedDate)
        setFragmentResult("requestKey", bundleOf("data" to selectedDate))

    }
}