package com.webapi.okhttp3

import okhttp3.Request
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.Test

class StringParsingTest : ApiBaseClass() {

    @AfterTest
    fun close() {
        response.close()
    }

    // STRING PARSING
    @Test
    fun bodyContainsCurrentUserUrl() {

        // Arrange - create request
        val request: Request = Request.Builder().addHeader("User-Agent", "OkHttp3")
                .url("$BASE_URL/users/izzyjr")
                .get()
                .build()

        // Act - send request
        response = httpClient.newCall(request).execute()
        responseBody = response.body!!

        // Assert
        Assert.assertTrue("\"login\":\"izzyjr\"" in responseBody.string())
    }
}