package entities


import com.fasterxml.jackson.annotation.JsonProperty

data class ResourcesX(
    @JsonProperty("core")
    var core: Core?,
    @JsonProperty("graphql")
    var graphql: Graphql?,
    @JsonProperty("integration_manifest")
    var integrationManifest: IntegrationManifest?,
    @JsonProperty("search")
    var search: Search?
)