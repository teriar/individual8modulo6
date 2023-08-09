package com.example.cl.ejercicio8modulo6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_razas")
class RazaEntity (

    @PrimaryKey val raza: String)