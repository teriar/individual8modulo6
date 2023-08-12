package com.example.cl.ejercicio8modulo6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface RazaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRaza(razaEntity: RazaEntity)

    //para pruebas android
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRaza(razaEntity: List<RazaEntity>)

    @Query("Select * from tabla_razas order by raza asc")
    fun getRazas():LiveData<List<RazaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarRazaDetalle(razaDetalleEntity: RazaDetalleEntity)

    @Query("Select * from tabla_razasDetalle where razaDetalle like :id")
    fun getImagesRaza(id:String):LiveData<List<RazaDetalleEntity>>
}