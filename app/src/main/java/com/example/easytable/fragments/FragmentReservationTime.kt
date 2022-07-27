package com.example.easytable.fragments

import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResultListener
import com.example.easytable.Database.AppDatabase
import com.example.easytable.Models.Reservation
import com.example.easytable.databinding.FragmentReservationTimeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class FragmentReservationTime : DialogFragment(), TimePickerDialog.OnTimeSetListener {



    private var _binding: FragmentReservationTimeBinding?=null
    private val binding get() = _binding
    private lateinit var appDB: AppDatabase
    private var date:String=""
    private var time:String=""
    @RequiresApi(Build.VERSION_CODES.N)
    private val calendar = Calendar.getInstance()
    private val formatter = SimpleDateFormat("HH:mm", Locale.ENGLISH)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReservationTimeBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onStart() {
        super.onStart()
        appDB= activity?.let { AppDatabase.getDatabase(it.applicationContext ) }!!

        setFragmentResultListener("REQUEST_KEY"){
                key,bundle-> date = bundle.getString("date").toString()
        }

        binding?.btnSubmitTime?.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                writeData(date, time)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        TimePickerDialog(this.context, this, hour, minute, true).show()
        return TimePickerDialog(this.context, this, hour, minute, true)
    }

     @RequiresApi(Build.VERSION_CODES.O)
     fun writeData(date:String, time:String){

         val reservation = Reservation( null, date, time)

         GlobalScope.launch(Dispatchers.IO) {
            appDB.reservationDao().add(reservation)
         }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)
         time = formatter.format(calendar.timeInMillis)
    }
}
