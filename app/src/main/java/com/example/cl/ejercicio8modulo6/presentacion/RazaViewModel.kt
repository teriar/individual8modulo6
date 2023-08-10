package com.example.cl.ejercicio8modulo6.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cl.ejercicio8modulo6.data.Repositorio
import com.example.cl.ejercicio8modulo6.data.local.RazaDatabase
import com.example.cl.ejercicio8modulo6.data.remote.PerroRetrofit
import kotlinx.coroutines.launch

class RazaViewModel(application: Application):AndroidViewModel(application) {
    private val repositorio: Repositorio

   fun razaLiveDAta() = repositorio.obtenerRazaEntity()

    init {
        val api = PerroRetrofit.getRetrofitPerros()
        val dao = RazaDatabase.getDataBase(application).getRazaDao()
        repositorio = Repositorio(api, dao)
    }

    fun getData()=viewModelScope.launch {
        repositorio.getRazas()
    }

    fun getDataPerro(id:String) = viewModelScope.launch {
        repositorio.getDetallePerro(id)
    }

}