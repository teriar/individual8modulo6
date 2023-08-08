package com.example.cl.ejercicio8modulo6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface RazaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRaza(razaEntity: RazaEntity)

    @Query("Select * from tabla_razas order by raza desc")
    fun getRazas():LiveData<RazaEntity>
}