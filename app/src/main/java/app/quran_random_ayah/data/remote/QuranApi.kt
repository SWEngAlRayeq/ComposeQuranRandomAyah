package app.quran_random_ayah.data.remote

import app.quran_random_ayah.data.model.RandomAyahResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuranApi {

    @GET("ayah/random")
    suspend fun getRandomAyah(
        @Query("t") timestamp: Long = System.currentTimeMillis()
    ): RandomAyahResponse

}