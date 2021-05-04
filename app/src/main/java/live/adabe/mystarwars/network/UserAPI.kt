package live.adabe.mystarwars.network

import androidx.lifecycle.LiveData
import live.adabe.mystarwars.model.ApiResponse
import retrofit2.http.GET

interface UserAPI {
    @GET("people")
    suspend fun getPeople(): ApiResponse
}