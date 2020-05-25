import org.apache.http.Header
import org.apache.http.client.methods.CloseableHttpResponse

class ResponseUtils {

    companion object {
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

        fun getHeaderWithSequence(res: CloseableHttpResponse, headerName: String): String? {
            val headers: Array<Header> = res.allHeaders
            val httpHeaders = headers.toList()
            val matchedHeader: Header? = httpHeaders.asSequence()
                    .filter { header -> headerName == header.name }
                    .firstOrNull()
            return matchedHeader?.value
        }

        fun headerIsPresent(res: CloseableHttpResponse, headerName: String): Boolean  {
            val headers: Array<Header> = res.allHeaders
            val httpHeaders = headers.toList()
            return httpHeaders.asSequence()
                    .any { header -> headerName == header.name }
        }

    }

}