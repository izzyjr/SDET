package com.framework

import org.testng.Assert
import org.testng.annotations.Test

class MyFirstTest {

    @Test
    fun firstTest() {
        val actual: Int = sum(2, 2)
        Assert.assertEquals(actual, 4)
    }

}

fun sum(a: Int, b: Int): Int {
    return a + b
}
