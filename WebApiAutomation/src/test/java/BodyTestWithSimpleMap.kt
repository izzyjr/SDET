import entities.User.Companion.EMAIL
import entities.User.Companion.ID
import entities.User.Companion.LOGIN
import entities.User.Companion.TYPE
import org.apache.http.Header
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.entity.ContentType
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils
import org.json.JSONObject
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class BodyTestWithSimpleMap : ResponseUtils() {

    private lateinit var client: CloseableHttpClient
    private lateinit var response: CloseableHttpResponse
    private lateinit var contentType: Header
    private lateinit var ct: ContentType
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
        val jsonBody = EntityUtils.toString(response.entity)
        val jsonObject = JSONObject(jsonBody)
        val loginValue = getValueFor(jsonObject, LOGIN) as String
        Assert.assertEquals(loginValue, "andrejss88")
    }

    @Test
    fun returnsCorrectID() {
        get = HttpGet("$BASE_ENDPOINT/users/andrejss88")
        response = client.execute(get)
        val jsonBody = EntityUtils.toString(response.entity)
        val jsonObject = JSONObject(jsonBody)
        val loginValue = getValueFor(jsonObject, ID) as Int
        Assert.assertEquals(loginValue, 11834443)
    }

    @Test
    fun returnsType() {
        get = HttpGet("$BASE_ENDPOINT/users/andrejss88")
        response = client.execute(get)
        val jsonBody = EntityUtils.toString(response.entity)
        val jsonObject = JSONObject(jsonBody)
        val loginValue = getValueFor(jsonObject, TYPE) as String
        Assert.assertEquals(loginValue, "User")
    }

    @Test
    fun returnsEmail() {
        get = HttpGet("$BASE_ENDPOINT/users/andrejss88")
        response = client.execute(get)
        val jsonBody = EntityUtils.toString(response.entity)
        val jsonObject = JSONObject(jsonBody)
        val loginValue = getValueFor(jsonObject, EMAIL) as String
        Assert.assertNull(loginValue)
    }

}