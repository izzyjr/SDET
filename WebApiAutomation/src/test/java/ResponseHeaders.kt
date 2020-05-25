import Get200.Companion.BASE_ENDPOINT
import org.apache.http.Header
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.entity.ContentType
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import kotlin.test.assertEquals

class ResponseHeaders {

    private lateinit var client: CloseableHttpClient
    lateinit var get: HttpGet
    private lateinit var response: HttpResponse
    private lateinit var contentType: Header
    private lateinit var ct: ContentType

    @BeforeMethod
    fun setup() {
        client = HttpClientBuilder.create().build()
    }

    @AfterMethod
    fun closeResources() {
        client.close()
    }

    @Test
    fun contentTypeIsJson() {
        get = HttpGet(BASE_ENDPOINT)
        response = client.execute(get)
        contentType = response.entity.contentType
        Assert.assertEquals(contentType.value, "application/json; charset=utf-8")
        ct = ContentType.getOrDefault(response.entity)
        Assert.assertEquals(ct.mimeType, "application/json")
    }

}