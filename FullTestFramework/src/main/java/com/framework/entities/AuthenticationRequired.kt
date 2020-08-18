package com.framework.entities


import com.fasterxml.jackson.annotation.JsonProperty

data class AuthenticationRequired(
    @JsonProperty("documentation_url")
    var documentationUrl: String?,
    @JsonProperty("message")
    var message: String?
)