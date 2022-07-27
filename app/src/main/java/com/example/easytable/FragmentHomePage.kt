package com.example.easytable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.easytable.databinding.FragmentHomePageBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FragmentHomePage : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    var _binding: FragmentHomePageBinding?=null
    val binding get() = _binding


    val frgRestaurants = FragmentRestaurants()
    val frgBars = FragmentBars()
    val frgCafes = FragmentCafe()
    val frgHookahPlaces = FragmentHookah()
    //val frgReservation = FragmentReservation()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onStart() {
        super.onStart()
        binding?.btnBars?.setOnClickListener {
            this.activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.change, frgBars)
                ?.addToBackStack("bars")
                ?.commit()
        }

        binding?.btnRestaurants?.setOnClickListener {
            this.activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.change, frgRestaurants)
                ?.addToBackStack("bars")
                ?.commit()
        }

        binding?.btnCafes?.setOnClickListener {
            this.activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.change, frgCafes)
                ?.addToBackStack("bars")
                ?.commit()
        }

        binding?.btnHookah?.setOnClickListener {
            this.activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.change, frgHookahPlaces)
                ?.addToBackStack("bars")
                ?.commit()
        }
    }











    companion object {

        fun newInstance(param1: String, param2: String) =
            FragmentHomePage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}