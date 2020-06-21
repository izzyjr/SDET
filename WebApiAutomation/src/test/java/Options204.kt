import ResponseUtils.Companion.BASE_ENDPOINT
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpOptions
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class Options204 {

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
    fun optionsReturnsCorrectMethodsList() {
        val header: String = "Access-Control-Allow-Methods"
        val expectedReply = "GET, POST, PATCH, PUT, DELETE"
        val request: HttpOptions = HttpOptions(BASE_ENDPOINT)
        response = client.execute(request)
        val actualValue: String = ResponseUtils.getHeader(response, header)
        println(actualValue)
        Assert.assertEquals(actualValue, expectedReply)
    }

}