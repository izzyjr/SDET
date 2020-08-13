package com.framework.okhttp3

import Utils.Companion.EMAIL
import Utils.Companion.PASSWORD
import com.framework.MesaUtils.Companion.BASE_URL
import okhttp3.*
import org.testng.Assert.assertEquals
import org.testng.annotations.Test
import okhttp3.RequestBody.Companion.toRequestBody

class PostTest {

    @Test
    fun postWithoutAuthorizationFails() {

        // Arrange - create client
        val httpClient: OkHttpClient = OkHttpClient()

        // Arrange - create request
        val json: String = "{\"name\": \"deleteme\"}"

        val request: Request = Request.Builder()
                .url("$BASE_URL/user/repos")
                .addHeader("Authorization", Credentials.basic(EMAIL, PASSWORD))
                .post(json.toRequestBody())
                .build()

        // Act - send request
        val response: Response = httpClient.newCall(request).execute()
        val actualCode: Int = response.code

        // Assert
        assertEquals(actualCode, 201)

    }

}