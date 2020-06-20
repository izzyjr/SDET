package entities


import com.fasterxml.jackson.annotation.JsonProperty

data class RateLimit(
    @JsonProperty("rate")
    var rate: Rate?,
    @JsonProperty("resources")
    var resources: ResourcesX?
)