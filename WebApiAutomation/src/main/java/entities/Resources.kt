package entities

import com.fasterxml.jackson.annotation.JsonProperty

class Resources(
        var coreLimit: Int?,
        var coreRemaining: Int?,
        var coreReset: Int?,
        var graphqlLimit: Int?,
        var graphqlRemaining: Int?,
        var graphqlReset: Int?,
        var searchLimit: Int?,
        var searchRemaining: Int?,
        var searchReset: Int?) {

    @JsonProperty("resources")
    fun unmarshallNested(resources: HashMap<String, Any>) {
        val core: HashMap<String, Int> = resources["core"] as HashMap<String, Int>
        this.coreLimit = core["limit"]
        this.coreRemaining = core["remaining"]
        this.coreReset = core["reset"]

        val graphql: HashMap<String, Int> = resources["graphql"] as HashMap<String, Int>
        this.graphqlLimit = graphql["limit"]
        this.graphqlRemaining = graphql["remaining"]
        this.graphqlReset = graphql["reset"]

        val search: HashMap<String, Int> = resources["search"] as HashMap<String, Int>
        this.searchLimit = search["limit"]
        this.searchRemaining = search["remaining"]
        this.searchReset = search["reset"]
    }

}