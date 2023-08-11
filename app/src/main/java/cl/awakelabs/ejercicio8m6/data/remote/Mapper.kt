package cl.awakelabs.ejercicio8m6.data.remote
/*+
* Test unitario
* */
import cl.awakelabs.ejercicio8m6.data.local.RaceDetailEntity

fun String.toEntity(id: String): RaceDetailEntity = RaceDetailEntity(id,this)//funcion de extension