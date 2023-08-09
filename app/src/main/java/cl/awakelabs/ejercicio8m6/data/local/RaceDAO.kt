package cl.awakelabs.ejercicio8m6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RaceDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRace(raceEntity: RaceEntity)

    @Query("select * from tbl_razas order by race desc")
    fun getRace(): LiveData<List<RaceEntity>>
}