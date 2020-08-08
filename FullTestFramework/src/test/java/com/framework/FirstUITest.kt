package com.framework

import com.framework.uitests.BaseTestClass
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.testng.Assert.assertEquals
import org.testng.annotations.AfterTest
import org.testng.annotations.Test

class FirstUITest : BaseTestClass() {

    init {
        setUp()
    }

    @Test(enabled = true)
    fun userNameIsCorrectOnOverviewTab() {

        // Arrange
        driver.get(USER_URL)

        // Act
        val actualUserName: String = driver.findElement(By.className("p-nickname")).text

        // Assert
        assertEquals(actualUserName, USER)
    }

    @Test(enabled = true)
    fun repoLinkGoesToCorrectRepo() {

        // Arrange
        driver.get(USER_URL)

        // Act
        val repository: WebElement = driver.findElement(By.xpath(TRIBUTE_REPO_XPATH))
        repository.click()

        // Assert
        val actualRepoUrl: String = driver.currentUrl
        assertEquals(actualRepoUrl, TRIBUTE_REPO)
    }

    @Test(enabled = true)
    fun countNumberOfRepos() {

        // Arrange
        val expectedRepoCount: Int = 66
        driver.get(REPOS_URL)

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