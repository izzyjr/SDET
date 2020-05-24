import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.testng.Assert
import org.testng.annotations.Test

class Get200 {

    @Test
    fun baseUrlReturns200() {
        val get = HttpGet(BASE_URL)
        val response: HttpResponse = client.execute(get)
        val actualStatus = response.statusLine.statusCode
        Assert.assertEquals(actualStatus, 200)
    }

    companion object {
      const val BASE_URL = "https://api.github.com"
        val client: CloseableHttpClient = HttpClientBuilder.create().build()
    }

}