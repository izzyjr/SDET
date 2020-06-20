package entities


import com.fasterxml.jackson.annotation.JsonProperty

data class Search(
    @JsonProperty("limit")
    var limit: Int?,
    @JsonProperty("remaining")
    var remaining: Int?,
    @JsonProperty("reset")
    var reset: Int?
)