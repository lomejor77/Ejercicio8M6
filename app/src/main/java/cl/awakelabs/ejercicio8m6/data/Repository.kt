    package cl.awakelabs.ejercicio8m6.data

    import android.util.Log
    import androidx.lifecycle.LiveData
    import cl.awakelabs.ejercicio8m6.data.local.RaceDAO
    import cl.awakelabs.ejercicio8m6.data.local.RaceDetailEntity
    import cl.awakelabs.ejercicio8m6.data.local.RaceEntity
    import cl.awakelabs.ejercicio8m6.data.remote.RaceAPI

    class Repository(private val raceAPI: RaceAPI, private val raceDAO: RaceDAO) {

        fun obtainRaceEntity(): LiveData<List<RaceEntity>> = raceDAO.getRace()
        fun obtainRaceDetailEntity(id: String): LiveData<List<RaceDetailEntity>> = raceDAO.getRaceDetail(id)
        suspend fun getRace(){
            val response= raceAPI.getData()
             if (response.isSuccessful) {
                 val message = response.body()!!.message
                 val keys = message.keys
                 keys.forEach {
                     val raceEntity = RaceEntity(it)
                     raceDAO.insertRace(raceEntity)
                 }

             }else{
                 Log.e("repositorio", response.errorBody().toString())
             }
        }

        suspend fun getDetailRace(id: String){
            val response= raceAPI.getDetailDog(id)
            if (response.isSuccessful) {
                response.body()!!.message.forEach {
                    val raceDetail = RaceDetailEntity(id,it)
                    raceDAO.insertRaceDetail(raceDetail)
                }

            }else{
                    Log.e("repository", response.errorBody().toString())
            }

        }
    }
