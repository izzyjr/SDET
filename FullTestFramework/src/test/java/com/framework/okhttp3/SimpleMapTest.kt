package com.framework.okhttp3


import com.framework.okhttp3.SimpleMapTest.Properties.bio
import com.framework.okhttp3.SimpleMapTest.Properties.email
import com.framework.okhttp3.SimpleMapTest.Properties.id
import com.framework.okhttp3.SimpleMapTest.Properties.login
import com.framework.okhttp3.SimpleMapTest.Properties.type
import org.json.JSONObject
import org.testng.Assert.assertEquals
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class SimpleMapTest : ApiBaseClass() {

    private lateinit var loginValue: Any
    private lateinit var jsonObject: JSONObject

    @BeforeTest
    fun setUp() {
        jsonObject = userEndpointSendRequest()
    }

    @AfterTest
    fun close() {
        response.close()
    }

    @Test
    fun returnsCorrectLogin() {
        loginValue = getValueFor(jsonObject, login)
        assertEquals(loginValue, "izzyjr")
    }

    @Test
    fun returnsCorrectID() {
        loginValue = getValueFor(jsonObject, id)
        assertEquals(loginValue, 29586548)
    }

    @Test
    fun returnsType() {
        loginValue = getValueFor(jsonObject, type)
        assertEquals(loginValue, "User")
    }

    @Test
    fun returnsEmail() {
        loginValue = getValueFor(jsonObject, email)
        assertEquals(loginValue.toString(), "null")
    }

    @Test
    fun returnsBio() {
        loginValue = getValueFor(jsonObject, bio)
        assertEquals(loginValue.toString(), "∆")
    }

    object Properties {
        val login: String = loadProp("login")
        val id: String = loadProp("id")
        val type: String = loadProp("type")
        val email: String = loadProp("email")
        val bio: String = loadProp("bio")
    }

}