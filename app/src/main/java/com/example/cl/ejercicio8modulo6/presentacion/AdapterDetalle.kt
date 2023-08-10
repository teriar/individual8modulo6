package com.example.cl.ejercicio8modulo6.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cl.ejercicio8modulo6.data.local.RazaDetalleEntity
import com.example.cl.ejercicio8modulo6.databinding.FragmentDetalleBinding
import com.example.cl.ejercicio8modulo6.databinding.ItemDetallePerroBinding

class AdapterDetalle:RecyclerView.Adapter<AdapterDetalle.DetallePerroViewHolder>() {
      lateinit var  binding:  ItemDetallePerroBinding
      private val listDetalleperro = mutableListOf<RazaDetalleEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDetalle.DetallePerroViewHolder {
        binding = ItemDetallePerroBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return DetallePerroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterDetalle.DetallePerroViewHolder, position: Int) {
        val perro = listDetalleperro[position]
        holder.bind(perro)
    }

    override fun getItemCount(): Int {
        return listDetalleperro.size
    }

    fun setData(detalle : List<RazaDetalleEntity>){
        this.listDetalleperro.clear()
        this.listDetalleperro.addAll(detalle)
        notifyDataSetChanged()

    }

    class DetallePerroViewHolder(val perrovista:ItemDetallePerroBinding):RecyclerView.ViewHolder(perrovista.root) {

        fun bind(detalle: RazaDetalleEntity){
            perrovista.imageView.load(detalle.url)
        }

    }
}