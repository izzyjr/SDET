import entities.User.Companion.BASE_ENDPOINT
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

    @BeforeMethod
    fun setup() {
        client = HttpClientBuilder.create().build()
    }

    @AfterMethod
    fun closeResources() {
        client.close()
    }

    @Test
    fun nonExistentUrlReturns404() {
        get = HttpGet("$BASE_ENDPOINT/nonexistanturl")
        response = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 404)
    }

}