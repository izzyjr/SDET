import org.apache.http.Header
import org.apache.http.HttpResponse
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class Get200 {

    private lateinit var client: CloseableHttpClient
    private lateinit var response: CloseableHttpResponse

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
    fun baseUrlReturns200() {
        response = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 200)
    }


    companion object {
        const val BASE_ENDPOINT = "https://api.github.com"
        val get: HttpGet = HttpGet(BASE_ENDPOINT)
        val endpointsArray = arrayOf("/user", "/user/followers", "/notifications")
    }

}