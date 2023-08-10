package cl.awakelabs.ejercicio8m6.data.local

import androidx.room.Entity

@Entity(tableName = "tbl_racedetail", primaryKeys = ["raceDetail","url"])
class RaceDetailEntity(
    val raceDetail: String,
    val url: String
)
