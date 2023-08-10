package cl.awakelabs.ejercicio8m6.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RaceAPI  {
    @GET("breeds/list/all")
    suspend fun getData(): Response<RaceDogDataClass>

    @GET("breed/{id}/images")
    suspend fun getDetailDog(@Path("id") id: String): Response<RaceDetailDataClass>
}