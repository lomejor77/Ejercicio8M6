package cl.awakelabs.ejercicio8m6.data

import androidx.lifecycle.LiveData
import cl.awakelabs.ejercicio8m6.data.local.RaceDAO
import cl.awakelabs.ejercicio8m6.data.local.RaceEntity
import cl.awakelabs.ejercicio8m6.data.remote.RaceAPI
import retrofit2.Response

class Repository(private val raceAPI: RaceAPI, private val raceDAO: RaceDAO) {

    fun obtainRaceEntity(): LiveData<List<RaceEntity>> = raceDAO.getRace()
    suspend fun getRace(){
        val response= raceAPI.getData()
         if (response.isSuccessful) {
             val message = response.body()!!.message
             val keys = message.keys
             keys.forEach {
                 val raceEntity = RaceEntity(it)
                 raceDAO.insertRace(raceEntity)
             }

         }
    }

}