package com.framework.okhttp3

import com.framework.entities.User.Companion.EMAIL
import com.framework.entities.User.Companion.ID
import com.framework.entities.User.Companion.LOGIN
import com.framework.entities.User.Companion.TYPE
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
        jsonObject = userSendRequest()
    }

    @AfterTest
    fun close() {
        response.close()
    }

    @Test
    fun returnsCorrectLogin() {
        loginValue = getValueFor(jsonObject, LOGIN)
        assertEquals(loginValue.toString(), "izzyjr")
    }

    @Test
    fun returnsCorrectID() {
        loginValue = getValueFor(jsonObject, ID)
        assertEquals(loginValue as Int, 29586548)
    }

    @Test
    fun returnsType() {
        loginValue = getValueFor(jsonObject, TYPE)
        assertEquals(loginValue, "User")
    }

    @Test
    fun returnsEmail() {
        loginValue = getValueFor(jsonObject, EMAIL)
        assertEquals(loginValue.toString(), "null")
    }

}