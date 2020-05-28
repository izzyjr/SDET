import ResponseUtils.Companion.BASE_ENDPOINT
import ResponseUtils.Companion.unmarshalUser
import entities.User
import org.apache.http.Header
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.entity.ContentType
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class BodyTestWithJackson {

    private lateinit var client: CloseableHttpClient
    private lateinit var response: CloseableHttpResponse
    private lateinit var contentType: Header
    private lateinit var ct: ContentType
    private lateinit var user: User
    lateinit var get: HttpGet

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
    fun returnsCorrectLogin() {
        get = HttpGet("$BASE_ENDPOINT/users/andrejss88")
        response = client.execute(get)
        user = unmarshalUser(response)
        println(user.login)
        Assert.assertEquals(user.login, "andrejss88")
    }

    @Test
    fun returnsCorrectID() {
        get = HttpGet("$BASE_ENDPOINT/users/andrejss88")
        response = client.execute(get)
        user = unmarshalUser(response)
        println(user.id)
        Assert.assertEquals(user.id, 11834443)
    }

}