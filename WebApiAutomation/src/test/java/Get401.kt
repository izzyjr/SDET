import ResponseUtils.Companion.BASE_ENDPOINT
import ResponseUtils.Companion.endpointsArray
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class Get401 {

    private lateinit var client: CloseableHttpClient
    lateinit var get: HttpGet
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

    @DataProvider
    fun endpoints(): Array<String> {
        return endpointsArray
    }

    @Test(dataProvider = "endpoints")
    fun refactoredThreeIntoOne(endpoint: String) {
        get = HttpGet("$BASE_ENDPOINT$endpoint")
        response = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 401)
    }

    @Test
    fun userReturns401() {
        get = HttpGet("$BASE_ENDPOINT/user")
        response = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 401)
    }

    @Test
    fun userFollowersReturns401() {
        get = HttpGet("$BASE_ENDPOINT/user/followers")
        response = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 401)
    }

    @Test
    fun notificationsReturns401() {
        get = HttpGet("$BASE_ENDPOINT/notifications")
        response = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 401)
    }

}