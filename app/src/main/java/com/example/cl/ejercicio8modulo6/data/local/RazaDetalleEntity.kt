package com.example.cl.ejercicio8modulo6.data.local

import androidx.room.Entity


@Entity(tableName = "tabla_razasDetalle", primaryKeys = ["razaDetalle","url"])
data class RazaDetalleEntity (
    val razaDetalle:String,
    val url: String
)