package com.webapi.okhttp3

import com.webapi.okhttp3.ApiBaseClass.Companion.BASE_URL
import com.utils.Secret.Companion.EMAIL_USER
import com.utils.Secret.Companion.PASSWORD
import com.utils.Secret.Companion.TOKEN
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.testng.Assert.assertEquals
import org.testng.annotations.Test
import java.util.*

class PostAndDelete {

    private val httpClient: OkHttpClient = OkHttpClient()
    private lateinit var response: Response

    @Test(priority = 0)
    fun postWithoutAuthorizationFails() {

        // Set Authentication
        val auth: String = "$EMAIL_USER:$PASSWORD"
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

    @Test(priority = 1)
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