package cl.awakelabs.ejercicio8m6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_razas")
data class RaceEntity(val race: String){
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}
