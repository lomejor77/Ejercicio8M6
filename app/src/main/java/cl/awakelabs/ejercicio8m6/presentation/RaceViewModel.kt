package cl.awakelabs.ejercicio8m6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.awakelabs.ejercicio8m6.data.Repository
import cl.awakelabs.ejercicio8m6.data.local.RaceDataBase
import cl.awakelabs.ejercicio8m6.data.remote.DogRetroFit
import kotlinx.coroutines.launch


class RaceViewModel(application: Application): AndroidViewModel(application) {
    private val repository: Repository

    fun raceLiveData() = repository.obtainRaceEntity()
    init {
        val api = DogRetroFit.getRetroFitRace()
        val dao = RaceDataBase.getDatabase(application).getRaceDao()
        repository = Repository(api, dao)
   }
    fun getAllRace() = viewModelScope.launch { repository.getRace() }
}