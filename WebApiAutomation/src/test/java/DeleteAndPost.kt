import ResponseUtils.Companion.BASE_ENDPOINT
import org.apache.commons.codec.binary.Base64
import org.apache.http.HttpHeaders
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpDelete
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.nio.charset.Charset

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

    @ExperimentalStdlibApi
    @Test
    fun createRepoReturns201() {

        // Create an HttpPost with a valid endpoint
        val request: HttpPost = HttpPost("$BASE_ENDPOINT/user/repos")

        // Set the Basic Authentication Header with valid login and password
        val auth: String = "${Credentials.EMAIL}:${Credentials.PASSWORD}"
        val encodedAuth: ByteArray = Base64.encodeBase64(auth.toByteArray(Charsets.ISO_8859_1))
        val authHeader = "Basic " + String(encodedAuth)
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader)

        // Define JSON object to POST and set it as the Entity of the request(populate the body of the request)
        val json: String = "{\"name\": \"deleteme\"}"
        request.entity = StringEntity(json, ContentType.APPLICATION_JSON)

        // Send it
        response = client.execute(request)
        val actualStatusCode = response.statusLine.statusCode

        // test response 201
        Assert.assertEquals(actualStatusCode, 201)
    }

}