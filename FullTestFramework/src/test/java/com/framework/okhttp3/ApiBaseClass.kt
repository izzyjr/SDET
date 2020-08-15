package com.framework

import org.json.JSONObject

class MesaUtils {

    companion object {
        const val BASE_URL: String = "https://api.github.com"
        private val case1: Array<String> = arrayOf("content-type", "application/json; charset=utf-8")
        private val case2: Array<String> = arrayOf("X-RateLimit-Limit", "60")
        private val case3: Array<String> = arrayOf("server", "GitHub.com")
        private val case4: Array<String> = arrayOf("X-frame-options", "deny")
        val testHeaders: ArrayList<Array<String>> = arrayListOf(case1, case2, case3, case4)

        const val LOGIN = "login"
        const val ID = "id"
        const val TYPE = "type"
        const val EMAIL = "email"

        fun getValueFor(jsonObject: JSONObject, key: String): Any {
            return jsonObject.get(key)
        }

    }

}