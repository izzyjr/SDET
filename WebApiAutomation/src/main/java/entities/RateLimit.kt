package entities

import com.fasterxml.jackson.annotation.JsonProperty

class RateLimit(var coreLimit: Int?, var searchLimit: Int?) {

    @JsonProperty("resources")
    fun unmarshallNested(resources: HashMap<String, Any>) {
        val core: HashMap<String, Int> = resources["core"] as HashMap<String, Int>
        this.coreLimit = core["limit"]

        val search: HashMap<String, Int> = resources["search"] as HashMap<String, Int>
        this.searchLimit = search["limit"]
    }

}