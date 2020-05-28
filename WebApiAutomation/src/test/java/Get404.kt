import ResponseUtils.Companion.BASE_ENDPOINT
import ResponseUtils.Companion.unmarshalNotFound
import entities.NotFound
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class Get404 {

    lateinit var client: CloseableHttpClient
    lateinit var get: HttpGet
    lateinit var response: CloseableHttpResponse
    lateinit var message404: NotFound

    @BeforeMethod
    fun setup() {
        client = HttpClientBuilder.create().build()
    }

    @AfterMethod
    fun closeResources() {
        client.close()
        response.close()
    }

    @Test
    fun nonExistentUrlReturns404() {
        get = HttpGet("$BASE_ENDPOINT/nonexistanturl")
        response = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 404)
    }

    @Test
    fun messageNotFound404() {
        get = HttpGet("$BASE_ENDPOINT/nonexistanturl")
        response = client.execute(get)
        message404 = unmarshalNotFound(response)
        println(message404.toString())
        Assert.assertEquals(message404.message, "Not Found")
    }

    @Test
    fun urlDocumentationNotFound404() {
        get = HttpGet("$BASE_ENDPOINT/nonexistanturl")
        response = client.execute(get)
        message404 = unmarshalNotFound(response)
        Assert.assertEquals(message404.documentation_url, "https://developer.github.com/v3")
    }


}