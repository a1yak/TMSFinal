package com.example.easytablevilnius.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easytablevilnius.Adapter.PlacesAdapter
import com.example.easytablevilnius.Models.FoodPlacesViewModel
import com.example.easytablevilnius.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var viewModel: FoodPlacesViewModel
private lateinit var placesRecyclerView: RecyclerView
lateinit var adapter: PlacesAdapter

class FragmentCafe : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafe, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentCafe().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        placesRecyclerView = view.findViewById(R.id.recyclerCafes)
        placesRecyclerView.layoutManager = LinearLayoutManager(context)
        placesRecyclerView.setHasFixedSize(true)
        adapter = PlacesAdapter()
        placesRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(FoodPlacesViewModel::class.java)
        viewModel.allPlaces.observe(viewLifecycleOwner, Observer {
            adapter.updateList(it)
        })
    }
}