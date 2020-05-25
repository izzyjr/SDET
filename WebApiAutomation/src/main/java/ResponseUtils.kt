import org.apache.http.Header
import org.apache.http.client.methods.CloseableHttpResponse

class ResponseUtils() {

    fun getHeader(res: CloseableHttpResponse, headerName: String): String {

        // get all headers
        val headers: Array<Header> = res.allHeaders
        val httpHeaders = headers.toList()
        var returnHeader = ""

        // loop over the headers list
        for(header in httpHeaders) {
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

}