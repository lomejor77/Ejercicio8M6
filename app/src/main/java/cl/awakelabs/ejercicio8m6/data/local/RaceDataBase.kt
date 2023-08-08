package cl.awakelabs.ejercicio8m6.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RaceEntity::class], version = 1)
abstract class RaceDataBase: RoomDatabase() {
    abstract fun getRaceDao(): RaceDAO
    companion object {
        @Volatile
        private var INSTANCE: RaceDataBase? = null

        fun getDatabase(context: Context): RaceDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RaceDataBase::class.java,
                    "race_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}