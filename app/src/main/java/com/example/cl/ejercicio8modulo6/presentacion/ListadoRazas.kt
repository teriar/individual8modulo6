package com.example.cl.ejercicio8modulo6.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.cl.ejercicio8modulo6.R
import com.example.cl.ejercicio8modulo6.databinding.FragmentListadoRazasBinding


class ListadoRazas : Fragment() {

    lateinit var  binding: FragmentListadoRazasBinding
    private val  razaViewModel: RazaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoRazasBinding.inflate(layoutInflater,container,false)

        initAdapter()
       razaViewModel.getData()

        return  binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterRazas()


        razaViewModel.razaLiveDAta().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
        binding.recyclerView.adapter = adapter

    }


    }
