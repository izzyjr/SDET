package entities

import org.apache.http.client.methods.HttpGet
import org.json.JSONObject

class User {

    companion object {
        const val BASE_ENDPOINT = "https://api.github.com"
        const val LOGIN = "login"
        const val ID = "id"
        val get: HttpGet = HttpGet(BASE_ENDPOINT)
        val endpointsArray = arrayOf("/user", "/user/followers", "/notifications")
    }

}