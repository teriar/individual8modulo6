package com.example.cl.ejercicio8modulo6.data.remote

import com.example.cl.ejercicio8modulo6.data.local.RazaEntity

fun String.toEntity():RazaEntity = RazaEntity(this)