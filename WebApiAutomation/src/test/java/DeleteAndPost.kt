import Credentials.Companion
import org.apache.http.HttpHeaders
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpDelete
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class DeleteAndPost {

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
    fun deleteIsSuccessful() {
        val request: HttpDelete = HttpDelete(Credentials.MYGITHUB)
        request.setHeader(HttpHeaders.AUTHORIZATION, "token ${Credentials.TOKEN}")
        response = client.execute(request)
        val actualStatusCode = response.statusLine.statusCode
        Assert.assertEquals(actualStatusCode, 204)
    }

}