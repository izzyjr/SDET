package com.framework.okhttp3

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.framework.CommonPropertiesManager
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import org.json.JSONObject

open class ApiBaseClass : CommonPropertiesManager() {

    init {
        loadFile()
    }

    protected val httpClient: OkHttpClient = OkHttpClient()
    protected lateinit var response: Response
    protected lateinit var responseBody: ResponseBody
    private lateinit var jsonBody: String
    private val mapper = jacksonObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    open fun userEndpointSendRequest(): JSONObject {
        // Arrange - create request
        val request: Request = Request.Builder().addHeader("User-Agent", "OkHttp3")
                .url("$BASE_URL/users/izzyjr")
                .get()
                .build()

        // Act - send request
        response = httpClient.newCall(request).execute()
        responseBody = response.body!!
        jsonBody = responseBody.string()
        return JSONObject(jsonBody)
    }

    open fun getValueFor(jsonObject: JSONObject, key: String): Any {
        return jsonObject.get(key)
    }

    open fun sendRequest(endpoint: String): ResponseBody {
        // Arrange - create request
        val request: Request = Request.Builder().addHeader("User-Agent", "OkHttp3")
                .url(endpoint)
                .get()
                .build()

        // Act - send request
        response = httpClient.newCall(request).execute()
        return response.body!!
    }

    open fun <T> unmarshalGeneric(responseBody: ResponseBody, clazz: Class<T>): T {
        jsonBody = responseBody.string()
        return mapper.readValue(jsonBody, clazz)
    }

    companion object {
        const val BASE_URL: String = "https://api.github.com"

        private val case1: Array<String> = arrayOf("content-type", "application/json; charset=utf-8")
        private val case2: Array<String> = arrayOf("X-RateLimit-Limit", "60")
        private val case3: Array<String> = arrayOf("server", "GitHub.com")
        private val case4: Array<String> = arrayOf("X-frame-options", "deny")
        val testHeaders: ArrayList<Array<String>> = arrayListOf(case1, case2, case3, case4)
    }

}