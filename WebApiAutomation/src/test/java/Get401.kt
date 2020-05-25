import Get200.Companion.BASE_ENDPOINT
import Get200.Companion.client
import Get200.Companion.endpointsArray
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet
import org.testng.Assert
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class Get401 {

    @DataProvider
    fun endpoints(): Array<String> {
        return endpointsArray
    }

    @Test(dataProvider = "endpoints")
    fun refactoredThreeIntoOne(endpoint: String) {
        val get = HttpGet("$BASE_ENDPOINT$endpoint")
        val response: HttpResponse = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 401)
    }

    @Test
    fun userReturns401() {
        val get = HttpGet("$BASE_ENDPOINT/user")
        val response: HttpResponse = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 401)
    }

    @Test
    fun userFollowersReturns401() {
        val get = HttpGet("$BASE_ENDPOINT/user/followers")
        val response: HttpResponse = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 401)
    }

    @Test
    fun notificationsReturns401() {
        val get = HttpGet("$BASE_ENDPOINT/notifications")
        val response: HttpResponse = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 401)
    }

}