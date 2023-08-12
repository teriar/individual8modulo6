package com.example.cl.ejercicio8modulo6.data.remote



import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MapperKtTest {

    @Test
    fun testToEntity() {
        var nombreRaza = "dsa"
        val result = nombreRaza.toEntity()
        //assertEquals(nombreRaza,result.raza)
        assertThat(result.raza).isEqualTo(nombreRaza)

    }
}