import ResponseUtils.Companion.BASE_ENDPOINT
import ResponseUtils.Companion.unmarshalUser
import ResponseUtils.Companion.unmarshallGeneric
import entities.NotFound
import entities.RateLimit
import entities.User
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class BodyTestWithJackson {

    private lateinit var client: CloseableHttpClient
    private lateinit var response: CloseableHttpResponse
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
        val user: User = unmarshallGeneric(response, User::class.java)
        println(user.id)
        Assert.assertEquals(user.id, 11834443)
    }

    @Test
    fun returnsNotFound() {
        get = HttpGet("$BASE_ENDPOINT/nonexistingendpoint")
        response = client.execute(get)
        val notFoundMessage: NotFound = unmarshallGeneric(response, NotFound::class.java)
        println(notFoundMessage.message)
        Assert.assertEquals(notFoundMessage.message, "Not Found")
    }

    @Test
    fun correctRateLimitsAreSet() {
        get = HttpGet("$BASE_ENDPOINT/rate_limit")
        response = client.execute(get)
        val rateLimits: RateLimit = unmarshallGeneric(response, RateLimit::class.java)
        println(rateLimits.coreLimit)
        println(rateLimits.searchLimit)
        Assert.assertEquals(rateLimits.coreLimit, 60)
    }

}