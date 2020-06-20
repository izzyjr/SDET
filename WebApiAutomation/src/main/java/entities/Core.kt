package entities

import com.fasterxml.jackson.annotation.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("limit", "remaining", "reset")
class Core {
    @get:JsonProperty("limit")
    @set:JsonProperty("limit")
    @JsonProperty("limit")
    var limit: Int? = null
    @get:JsonProperty("remaining")
    @set:JsonProperty("remaining")
    @JsonProperty("remaining")
    var remaining: Int? = null
    @get:JsonProperty("reset")
    @set:JsonProperty("reset")
    @JsonProperty("reset")
    var reset: Int? = null
    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}