package com.example.cl.ejercicio8modulo6.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.cl.ejercicio8modulo6.data.local.RazaDao
import com.example.cl.ejercicio8modulo6.data.local.RazaDetalleEntity
import com.example.cl.ejercicio8modulo6.data.local.RazaEntity
import com.example.cl.ejercicio8modulo6.data.remote.Raza
import com.example.cl.ejercicio8modulo6.data.remote.RazaApi
import com.example.cl.ejercicio8modulo6.data.remote.toEntity
import retrofit2.Response

class Repositorio(private val razaApi: RazaApi, private val razaDao: RazaDao) {

    fun obtenerRazaEntity(): LiveData<List<RazaEntity>> = razaDao.getRazas()
    fun obtenerDetalleEntity(id:String):LiveData<List<RazaDetalleEntity>> = razaDao.getImagesRaza(id)

    suspend fun  getRazas(){
        val response:Response<Raza> = razaApi.getData()// aca llegan los datos
        if(response.isSuccessful){ //??llegaron los datos
            val message = response.body()!!.message // solo sacando la partte de maessage , sin status
            val keys = message.keys
            keys.forEach{
                //val razaEntity = RazaEntity(it)
                val razaEntity = it.toEntity()
                razaDao.insertRaza(razaEntity)

            }

        }else{
            Log.e("repositorio", response.errorBody().toString())
        }
    }

    suspend fun  getDetallePerro(id:String){
        val response = razaApi.getImages(id)// aca llegan los datos
        if(response.isSuccessful){
                response.body()!!.message.forEach {
                    val perroDetalle = RazaDetalleEntity(id,it)
                    razaDao.insertarRazaDetalle(perroDetalle)
                }


        }else{
            Log.e("repositorio", response.errorBody().toString())
        }
    }

}