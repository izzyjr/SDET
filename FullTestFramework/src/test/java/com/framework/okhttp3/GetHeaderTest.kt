package com.framework.okhttp3

import com.framework.okhttp3.ApiBaseClass.Companion.BASE_URL
import com.framework.okhttp3.ApiBaseClass.Companion.testHeaders
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.BeforeTest
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class GetHeaderTest {

    private val httpClient: OkHttpClient = OkHttpClient()
    private lateinit var response: Response

    @BeforeTest
    fun sendGetToBaseEndpoint() {

        // Arrange
        val request: Request = Request.Builder().addHeader("User-Agent", "OkHttp3")
                .url(BASE_URL).get().build()

        // Act
        response = httpClient.newCall(request).execute()
    }

    @Test
    fun getReturns200() {
        val actualCode: Int = response.code
        assertEquals(200, actualCode)
    }

    @DataProvider(name = "headerValues")
    fun dataProvider(): MutableIterator<Array<String>> {
        return testHeaders.iterator()
    }

    @Test(dataProvider = "headerValues")
    fun testingHeaders(header: String, expected: String) {
        val actualContentType: String = response.headers[header]!!
        assertEquals(expected, actualContentType)
    }



}