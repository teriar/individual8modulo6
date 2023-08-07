package com.example.cl.ejercicio8modulo6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
[] 2 pantallas: Listado y detalle
[] Permiso de internet
[] ViewBinding
[] Dependencias: Coil, Room, Retrofit, navigation, viewModel
[] navigation
[] Listado: RecyclerView + ViewHolder + Adapter
[] Detalle: RecyclerView + ViewHolder + Adapter
[] Repositorio
[] Remoto:
    [] Dataclass
    [] API (interfaz)
    [] Retrofit
[] Local:
    [] Database
    [] Entity
    [] DAO
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}