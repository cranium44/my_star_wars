package live.adabe.mystarwars.network

import android.util.Log
import live.adabe.mystarwars.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userAPI: UserAPI) {
    private var users = listOf<User>()
    suspend fun getUsers(): List<User> {
        try {
            val response = userAPI.getPeople()
            users = response.results
        } catch (t: Throwable) {
            Log.e("REPOSITORY", t.message.toString())
        }
        return users
    }
}