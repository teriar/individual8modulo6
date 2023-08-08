package com.example.cl.ejercicio8modulo6.data

import com.example.cl.ejercicio8modulo6.data.local.RazaDao
import com.example.cl.ejercicio8modulo6.data.local.RazaEntity
import com.example.cl.ejercicio8modulo6.data.remote.Raza
import com.example.cl.ejercicio8modulo6.data.remote.RazaApi
import retrofit2.Response

class Repositorio(private val razaApi: RazaApi, private val razaDao: RazaDao) {

    suspend fun  getRazas(){
        val response:Response<Raza> = razaApi.getData()// aca llegan los datos
        if(response.isSuccessful){ //??llegaron los datos
            val message = response.body()!!.message // solo sacando la partte de maessage , sin status
            val keys = message.keys
            keys.forEach{
                val razaEntity = RazaEntity(it)
                razaDao.insertRaza(razaEntity)

            }

        }
    }

}