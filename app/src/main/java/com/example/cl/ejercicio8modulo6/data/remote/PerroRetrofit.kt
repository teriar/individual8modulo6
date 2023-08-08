package com.example.cl.ejercicio8modulo6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PerroRetrofit {

    companion object{
        private const val URL_BASE = "https://dog.ceo/api/"

        fun getRetrofitPerros(): RazaApi{
            val mRetrofit =Retrofit.Builder()
                .baseUrl(URL_BASE)

                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(RazaApi::class.java)
        }
    }
}