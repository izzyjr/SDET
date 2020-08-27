package com.ui.uitests

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.testng.Assert.assertEquals
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class RepoTabTests : BaseTestClass() {

    @BeforeTest
    override fun setUp() {
        super.setUp()
        driver.get(REPOS_URL)
    }

    @Test(priority = 0)
    fun countNumberOfRepos() {

        // Arrange
        val expectedRepoCount: Int = 66

        // Act
        var flag: Boolean = true
        var actualRepoCount: Int = 0
        while (flag) {
            val repositories: MutableList<WebElement> = driver.findElements(By.xpath(REPOSITORIES_XPATH))
            actualRepoCount += repositories.size
            repositories.clear()
            val nextButton: WebElement = driver.findElement(By.xpath(NEXT_BUTTON_XPATH))
            if (nextButton.isEnabled) {
                nextButton.click()
            } else {
                flag = false
            }
        }

        // Assert
        assertEquals(actualRepoCount, expectedRepoCount)
    }

    @AfterTest
    override fun cleanUp() {
        super.cleanUp()
    }

}
