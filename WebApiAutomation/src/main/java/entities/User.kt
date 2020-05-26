package entities

import org.apache.http.client.methods.HttpGet

class User {

    companion object {
        const val BASE_ENDPOINT = "https://api.github.com"
        const val LOGIN = "login"
        const val ID = "id"
        const val TYPE = "type"
        const val EMAIL = "email"
        val get: HttpGet = HttpGet(BASE_ENDPOINT)
        val endpointsArray = arrayOf("/user", "/user/followers", "/notifications")
    }

}