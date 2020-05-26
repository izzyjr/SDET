import entities.User.Companion.get
import org.apache.http.client.methods.CloseableHttpResponse
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

}