package com.example.cl.ejercicio8modulo6.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RazaApi {
    @GET("breeds/list/all")
    suspend fun getData(): Response<Raza>

    @GET("breed/{id}/images")
    suspend fun  getImages(@Path("id") id:String): Response<PerroDetalle>
}