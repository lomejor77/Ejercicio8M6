package cl.awakelabs.ejercicio8m6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DogRetroFit {
    companion object{
        private const val URL_BASE = "https://dog.ceo/api/"

        fun getRetroFitRace(): RaceAPI {
            val mRetroFit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetroFit.create(RaceAPI::class.java)
        }
    }
}