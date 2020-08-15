package com.framework.okhttp3

import Utils.Companion.EMAIL
import Utils.Companion.PASSWORD
import Utils.Companion.TOKEN
import com.framework.MesaUtils.Companion.BASE_URL
import okhttp3.*
import org.testng.Assert.assertEquals
import org.testng.annotations.Test
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.*

class PostAndDelete {

    private val httpClient: OkHttpClient = OkHttpClient()
    private lateinit var response: Response

    @Test
    fun postWithoutAuthorizationFails() {

        // Set Authentication
        val auth: String = "$EMAIL:$PASSWORD"
        val encodedAuth: ByteArray = Base64.getEncoder().encode(auth.toByteArray(Charsets.ISO_8859_1))
        val authHeader: String = "Basic " + String(encodedAuth)

        // Arrange - create request
        val json: String = "{\"name\": \"deleteme\"}"

        val request: Request = Request.Builder()
                .url("$BASE_URL/user/repos")
                .addHeader("Authorization", authHeader)
                .post(json.toRequestBody())
                .build()

        // Act - send request
        response = httpClient.newCall(request).execute()
        val actualCode: Int = response.code

        // Assert
        assertEquals(actualCode, 201)
    }

    @Test
    fun deleteIsSuccessful() {

        // Arrange - create request
        val request: Request = Request.Builder()
                .url("$BASE_URL/repos/izzyjr/deleteme")
                .addHeader("Authorization", "token $TOKEN")
                .delete()
                .build()
        response = httpClient.newCall(request).execute()
        val actualCode: Int = response.code

        // Assert
        assertEquals(actualCode, 204)
    }

}