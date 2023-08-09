package com.example.cl.ejercicio8modulo6.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cl.ejercicio8modulo6.data.local.RazaEntity
import com.example.cl.ejercicio8modulo6.databinding.FragmentListadoRazasBinding
import com.example.cl.ejercicio8modulo6.databinding.ItemRazasBinding

class AdapterRazas: RecyclerView.Adapter<AdapterRazas.ItemRazasVIewHolder>() {

    lateinit var  binding : ItemRazasBinding
    private val listItemRazas = mutableListOf<RazaEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRazasVIewHolder {
        binding = ItemRazasBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ItemRazasVIewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemRazas.size
    }

    override fun onBindViewHolder(holder: ItemRazasVIewHolder, position: Int) {
        val raza = listItemRazas[position]
        holder.bind(raza)
    }

    fun setData(razas:List<RazaEntity>){
      this.listItemRazas.clear()
      this.listItemRazas.addAll(razas)
      notifyDataSetChanged()
    }

    class ItemRazasVIewHolder(val bindingraza:ItemRazasBinding): RecyclerView.ViewHolder(bindingraza.root) {

        fun bind(raza:RazaEntity){
           bindingraza.txtRaza.text = raza.raza


        }

    }
}