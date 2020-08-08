package com.framework.unitests

import org.openqa.selenium.By
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.Test

class OverviewTabTests : BaseTestClass() {

    init {
        setUp()
    }

    @Test(enabled = true)
    fun userNameIsCorrectOnOverviewTab() {

        // Arrange
        driver.get("${BaseTestClass.BASE_URL}${BaseTestClass.USER}")

        // Act
        val actualUserName: String = driver.findElement(By.className("p-nickname")).text

        // Assert
        Assert.assertEquals(actualUserName, BaseTestClass.USER)
    }

    @AfterTest
    override fun cleanUp() {
        super.cleanUp()
    }

}