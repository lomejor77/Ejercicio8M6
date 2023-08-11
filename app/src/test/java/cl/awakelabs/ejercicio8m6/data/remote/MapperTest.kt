package cl.awakelabs.ejercicio8m6.data.remote

import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun toEntity() {
        //la logica es dado este valor(de entrada) espero entonces: given when then
        val url = "http://example.com"
        val id = "datoId"

        val resultTransformation = url.toEntity(id)

        assertEquals(id, resultTransformation.raceDetail)
        assertEquals(url, resultTransformation.url)
    }
}