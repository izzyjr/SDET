package entities

data class User(var login: String, var id: Int) {

    companion object {
        const val LOGIN = "login"
        const val ID = "id"
        const val TYPE = "type"
        const val EMAIL = "email"
    }

}