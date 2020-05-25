import Get200.Companion.BASE_ENDPOINT
import Get200.Companion.client
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet
import org.testng.Assert
import org.testng.annotations.Test

class Get404 {

    @Test
    fun nonExistentUrlReturns404() {
        val get = HttpGet("$BASE_ENDPOINT/nonexistanturl")
        val response: HttpResponse = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 404)
    }

}