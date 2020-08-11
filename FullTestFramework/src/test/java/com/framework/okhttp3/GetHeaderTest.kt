package com.framework.okhttp3

import Utils.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test

class GetHeaderTest {

    @Test
    fun getReturns200() {

        // Arrange
        val httpClient: OkHttpClient = OkHttpClient()
        val request: Request = Request.Builder().addHeader("User-Agent", "OkHttp3")
                .url(BASE_URL).get().build()

        // Act
        val response: Response = httpClient.newCall(request).execute()
        val actualCode: Int = response.code

        // Assert
        assertEquals(200, actualCode)

    }

}