package com.ui.uitests

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.testng.Assert.assertEquals
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class OverviewTabTests : BaseTestClass() {

    @BeforeTest
    override fun setUp() {
        super.setUp()
        driver.get(USER_URL)
    }

    @Test(priority = 0)
    fun userNameIsCorrectOnOverviewTab() {

        // Act
        val actualUserName: String = driver.findElement(By.className("p-nickname")).text

        // Assert
        assertEquals(actualUserName, USER)
    }

    @Test(priority = 1)
    fun repoLinkGoesToCorrectRepo() {

        // Act
        val repository: WebElement = driver.findElement(By.xpath(TRIBUTE_REPO_XPATH))
        repository.click()

        // Assert
        val actualRepoUrl: String = driver.currentUrl
        assertEquals(actualRepoUrl, TRIBUTE_REPO)
    }

    @AfterTest
    override fun cleanUp() {
        super.cleanUp()
    }

}