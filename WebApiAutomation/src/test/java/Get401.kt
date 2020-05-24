import Get200.Companion.BASE_URL
import Get200.Companion.client
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet
import org.testng.Assert
import org.testng.annotations.Test

class Get401 {

    @Test
    fun userReturns401() {
        val get = HttpGet("$BASE_URL/user")
        val response: HttpResponse = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 200)
    }

    @Test
    fun userFollowersReturns401() {
        val get = HttpGet("$BASE_URL/user/followers")
        val response: HttpResponse = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 401)
    }

    @Test
    fun notificationsReturns401() {
        val get = HttpGet("$BASE_URL/notifications")
        val response: HttpResponse = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 401)
    }

}