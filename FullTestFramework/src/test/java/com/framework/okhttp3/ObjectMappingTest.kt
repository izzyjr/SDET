package com.framework.okhttp3

import com.framework.entities.AuthenticationRequired
import com.framework.entities.FullUserObject
import org.testng.annotations.AfterTest
import org.testng.annotations.Test
import org.testng.Assert.assertEquals

class ObjectMappingTest : ApiBaseClass() {

    @AfterTest
    fun close() {
        response.close()
    }

    @Test
    fun returnsCorrectBio() {
        responseBody = sendRequest("$BASE_URL/users/izzyjr")
        val user: FullUserObject = unmarshalGeneric(responseBody, FullUserObject::class.java)
        assertEquals(user.bio, "∆")
    }

    @Test
    fun postFails() {
        responseBody = sendRequest("$BASE_URL/user/repos")
        val authenticationRequired: AuthenticationRequired =
                unmarshalGeneric(responseBody, AuthenticationRequired::class.java)
        assertEquals(authenticationRequired.message, "Requires authentication")
    }
}