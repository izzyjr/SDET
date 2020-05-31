import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import entities.NotFound
import entities.User
import org.apache.http.Header
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.util.EntityUtils
import org.json.JSONObject

open class ResponseUtils {

    companion object {

        val mapper = jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        const val BASE_ENDPOINT = "https://api.github.com"
        val get: HttpGet = HttpGet(BASE_ENDPOINT)
        val endpointsArray = arrayOf("/user", "/user/followers", "/notifications")

        fun getHeader(res: CloseableHttpResponse, headerName: String): String {

            // get all headers
            val headers: Array<Header> = res.allHeaders
            val httpHeaders = headers.toList()
            var returnHeader = ""

            // loop over the headers list
            for (header in httpHeaders) {
                if (headerName == header.name) {
                    returnHeader = header.value
                }
            }

            // if no header found - throw an exception
            if (returnHeader.isEmpty()) {
                throw RuntimeException("Didn't find the header: $headerName")
            }

            // return the header
            return returnHeader
        }

        fun getHeaderWithSequence(res: CloseableHttpResponse, headerName: String): String? {
            val headers: Array<Header> = res.allHeaders
            val httpHeaders = headers.toList()
            val matchedHeader: Header? = httpHeaders.asSequence()
                    .filter { header -> headerName == header.name }
                    .firstOrNull()
            return matchedHeader?.value
        }

        fun headerIsPresent(res: CloseableHttpResponse, headerName: String): Boolean {
            val headers: Array<Header> = res.allHeaders
            val httpHeaders = headers.toList()
            return httpHeaders.asSequence()
                    .any { header -> headerName == header.name }
        }

        fun getValueFor(jsonObject: JSONObject, key: String): Any {
            return jsonObject.get(key)
        }

        fun unmarshalUser(response: CloseableHttpResponse): User {
            val jsonBody = EntityUtils.toString(response.entity)
            return mapper.readValue(jsonBody)
        }

        fun unmarshalNotFound(response: CloseableHttpResponse): NotFound {
            val jsonBody = EntityUtils.toString(response.entity)
            return mapper.readValue(jsonBody)
        }

        // It works!!
        fun <T> unmarshallGeneric(response: CloseableHttpResponse, clazz: Class<T>?): T {
            val jsonBody = EntityUtils.toString(response.entity)
            return mapper.readValue(jsonBody, clazz)
        }

    }

}