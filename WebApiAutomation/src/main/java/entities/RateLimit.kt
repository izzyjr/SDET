package entities

import com.fasterxml.jackson.annotation.JsonProperty
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class RateLimit(val coreLimit: Int, val searchLimit: String) {

    @JsonProperty("resources")
    fun unmarshallNested(resources: HashMap<String, Any>) {
        val core: HashMap<String, Int> = resources["core"] as HashMap<String, Int>
        val coreLimit: Int? = core["limit"]
    }

}